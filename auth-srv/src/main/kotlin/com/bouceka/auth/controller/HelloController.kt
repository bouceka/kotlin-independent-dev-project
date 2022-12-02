package com.bouceka.auth.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/auth/hello")
class HelloController {

	@Get
	fun index(): String {
		return "Hello World from auth-srv!"
	}
}
