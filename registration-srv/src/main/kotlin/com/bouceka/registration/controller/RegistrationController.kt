package com.bouceka.team.controller

import com.bouceka.registration.dto.CreateRegistrationDto
import com.bouceka.registration.entity.Registration
import com.bouceka.registration.service.RegistrationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/api/registration")
class RegistrationController(val registrationService: RegistrationService) {

	/*var userData: User = User("1", "John", "Doe", "john@doe.com", "password", "123456789", "123456", "Player")
	var playerData = com.bouceka.registration.models.Player("1", "", "male", userData)
	private var regitrationList =
		mutableListOf<Registration>(Registration("1", "Tuesday", "Registered", "Competitive", "playerData"))

	@Get
	fun findAll(): HttpResponse<List<Registration>> {
		return HttpResponse.ok(regitrationList)
	}*/
	@Get
	fun findAll(): HttpResponse<List<Registration>> {
		return HttpResponse.ok(registrationService.findAll())
	}

	@Get("/{id}")
	fun findById(@PathVariable id: UUID): HttpResponse<Optional<Registration>> {
		val foundRegistration = registrationService.findById(id)
		return if (foundRegistration != null) HttpResponse.ok(foundRegistration) else HttpResponse.notFound()
		//regitrationList.find { it.id == id }?.let { return HttpResponse.ok(it) } ?: return HttpResponse.notFound()
	}

	@Post
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun create(@Body body: CreateRegistrationDto): HttpResponse<Registration> {
		return HttpResponse.ok(registrationService.create(body))
	}

	@Delete("/{id}")
	fun delete(@PathVariable id: UUID): HttpResponse<String> {
		return if (registrationService.delete(id)) HttpResponse.ok("Registration was deleted") else HttpResponse.notFound(
			"Registration was not found!"
		)
	}
	/*
		@Put("/{id}")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		fun update(@PathVariable id: String, @Body body: UpdateRegistrationDto): HttpResponse<Registration?> {
			regitrationList.find { it.id == id }?.let { registration ->
				registration.matchDay = body.matchDay
				registration.proficiency = body.proficiency
				registration.status = body.status
				return HttpResponse.ok(registration)
			} ?: return HttpResponse.notFound()
		}

		@Post
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		fun create(@Body body: UpdateRegistrationDto): MutableHttpResponse<Any> {
			var newRegistration =
				Registration(UUID.randomUUID().toString(), body.matchDay, body.status, body.proficiency, playerData)
			regitrationList.add(newRegistration)
			return HttpResponse.created(newRegistration)
			//return HttpResponse.badRequest("Player already registered")
		}*/
}

