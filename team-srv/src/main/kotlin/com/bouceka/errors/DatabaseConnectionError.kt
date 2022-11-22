package com.bouceka.errors

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton


class DatabaseConnectionError : RuntimeException()

@Produces
@Singleton
@Requires(classes = [RuntimeException::class])
class DatabaseConnectionErrorHandler (private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
	ExceptionHandler<DatabaseConnectionError, HttpResponse<*>> {

	override fun handle(request: HttpRequest<*>, exception: DatabaseConnectionError): HttpResponse<*> {
		return errorResponseProcessor.processResponse(
			ErrorContext.builder(request)
				.cause(exception)
				.errorMessage("Error connecting to database")
				.build(), HttpResponse.serverError<Any>())
	}
}
