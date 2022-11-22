package com.bouceka.errors

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton


class NotFoundError : RuntimeException()

@Produces
@Singleton
@Requires(classes = [RuntimeException::class])
class NotFoundHandler(private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
	ExceptionHandler<NotFoundError, HttpResponse<*>> {

	override fun handle(request: HttpRequest<*>, exception: NotFoundError): HttpResponse<*> {
		return errorResponseProcessor.processResponse(
			ErrorContext.builder(request)
				.cause(exception)
				.errorMessage("Not found")
				.build(), HttpResponse.notFound<Any>())
	}
}

