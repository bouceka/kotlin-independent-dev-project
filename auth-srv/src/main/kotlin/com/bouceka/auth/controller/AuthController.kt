package com.bouceka.auth.controller

import com.bouceka.auth.dto.SignInDto
import com.bouceka.auth.dto.SignupDto
import com.bouceka.auth.entity.User
import com.bouceka.auth.service.AuthService
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api/auth")
class AuthController(private val authService: AuthService) {

	@Get("/currentuser")
	fun getCurrentUser(): String {
		return "user 1"
	}

	@Post
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun signIn(@Parameter email: String, @Parameter password: String): HttpResponse<User> {
		return HttpResponse.ok()
	}

	@Post("/signup")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun signUp(@Body body: SignupDto): HttpResponse<Unit> {
		return HttpResponse.ok(authService.signup(body))
	}

	@Get
	fun findAll(): HttpResponse<List<User>> {
		return HttpResponse.ok(authService.findAll())
	}
}
