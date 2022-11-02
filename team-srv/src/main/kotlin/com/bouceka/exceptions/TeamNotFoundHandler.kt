package com.bouceka.exceptions

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import jakarta.inject.Singleton


class TeamNotFound : RuntimeException()

@Produces
@Singleton
@Requires(classes = [RuntimeException::class])
class TeamNotFoundHandler(private val errorResponseProcessor: ErrorResponseProcessor<Any>) :
	ExceptionHandler<TeamNotFound, HttpResponse<*>> {

	override fun handle(request: HttpRequest<*>, exception: TeamNotFound): HttpResponse<*> {
		return errorResponseProcessor.processResponse(
			ErrorContext.builder(request)
				.cause(exception)
				.errorMessage("Team not found")
				.build(), HttpResponse.badRequest<Any>()) //
	}
}

