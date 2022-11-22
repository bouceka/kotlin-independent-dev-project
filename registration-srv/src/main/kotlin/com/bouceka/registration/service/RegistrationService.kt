package com.bouceka.registration.service

import com.bouceka.errors.BadRequestError
import com.bouceka.registration.dto.RegistrationDto
import com.bouceka.registration.entity.Registration
import com.bouceka.registration.repository.RegistrationRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Singleton
import java.util.*

@Singleton
class RegistrationService(private val registrationRepository: RegistrationRepository) {

	fun findAll(): List<Registration> {
		return registrationRepository.findAll().toList()
	}

	fun findById(id: UUID): Optional<Registration> {
		return registrationRepository.findById(id)
	}

	fun create(@Body body: RegistrationDto): Registration {
		var newRegistration = Registration(
			UUID.randomUUID(), body.matchDay, body
				.status, body.proficiencyId, body.userId
		)
		return registrationRepository.save(newRegistration)
	}

	fun update(@PathVariable id: UUID, @Body body: RegistrationDto): Registration {
		if (registrationRepository.findById(id).isEmpty)throw BadRequestError("Registration not found")

		return registrationRepository.update(
			Registration(
				id,
				matchDay = body.matchDay,
				status = body.status,
				proficiency_id = body.proficiencyId,
				user_id = body.userId
			)
		)
	}

	fun delete(id: UUID): Optional<Registration> {
		val foundRegistration = registrationRepository.findById(id)
		if (foundRegistration.isEmpty) throw throw BadRequestError("Team not found")
		registrationRepository.deleteById(id)
		return foundRegistration

	}
}
