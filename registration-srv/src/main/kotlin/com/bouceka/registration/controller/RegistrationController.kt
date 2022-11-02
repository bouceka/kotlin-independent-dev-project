package com.bouceka.team.controller

import com.bouceka.registration.dto.RegistrationDto
import com.bouceka.registration.entity.Registration
import com.bouceka.registration.service.RegistrationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/api/registration")
class RegistrationController(val registrationService: RegistrationService) {

	@Get
	fun findAll(): HttpResponse<List<Registration>> {
		return HttpResponse.ok(registrationService.findAll())
	}

	@Get("/{id}")
	fun findById(@PathVariable id: UUID): HttpResponse<Optional<Registration>> {
		val foundRegistration = registrationService.findById(id)
		return if (foundRegistration.isPresent) HttpResponse.ok(foundRegistration) else HttpResponse.notFound()
	}

	@Post
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun create(@Body body: RegistrationDto): HttpResponse<Registration> {
		return HttpResponse.ok(registrationService.create(body))
	}

	@Delete("/{id}")
	fun delete(@PathVariable id: UUID): HttpResponse<Optional<Registration>> {
		return  HttpResponse.ok(registrationService.delete(id))
	}

	@Put("/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun update(@PathVariable id: UUID, @Body body: RegistrationDto): HttpResponse<Registration> {
		return HttpResponse.ok(registrationService.update(id, body))
	}


}

