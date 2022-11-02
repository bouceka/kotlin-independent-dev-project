package com.bouceka.registration.exceptions

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton


class RegistrationNotFound : RuntimeException()

@Produces
@Singleton
@Requires(classes = [RuntimeException::class])
class RegistrationNotFoundHandler(private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
	ExceptionHandler<RegistrationNotFound, HttpResponse<*>> {

	override fun handle(request: HttpRequest<*>, exception: RegistrationNotFound): HttpResponse<*> {
		return errorResponseProcessor.processResponse(
			ErrorContext.builder(request)
				.cause(exception)
				.errorMessage("Registration not found")
				.build(), HttpResponse.badRequest<Any>()) //
	}
}

