package com.bouceka.player.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/api/registration/hello")
class HelloController {

	@Get
	fun index(): String {
		return "Hello World from registration-srv!"
	}
}
