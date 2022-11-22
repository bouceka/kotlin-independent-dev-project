package com.bouceka.errors

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton

class GlobalException(override val message: String, val httpResponse: MutableHttpResponse<Any>) : RuntimeException()

@Produces
@Singleton
@Requires(classes = [RuntimeException::class])
class GlobalExceptionHandler(private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
	ExceptionHandler<GlobalException, HttpResponse<*>> {

	override fun handle(request: HttpRequest<*>, exception: GlobalException): HttpResponse<*> {
		return errorResponseProcessor.processResponse(
			ErrorContext.builder(request)
				.cause(exception)
				.errorMessage(exception.message)
				.build(), exception.httpResponse)
	}
}

