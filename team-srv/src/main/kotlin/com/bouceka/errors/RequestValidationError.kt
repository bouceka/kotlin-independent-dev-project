package com.bouceka.errors

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton


class RequestValidationError(override val message: String?) : RuntimeException()

@Produces
@Singleton
@Requires(classes = [RuntimeException::class])
class RequestValidationErrorHandler (private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
	ExceptionHandler<RequestValidationError, HttpResponse<*>> {

	override fun handle(request: HttpRequest<*>, exception: RequestValidationError): HttpResponse<*> {
		return errorResponseProcessor.processResponse(
			ErrorContext.builder(request)
				.cause(exception)
				.errorMessage(exception.message)
				.build(), HttpResponse.badRequest<Any>())
	}
}
