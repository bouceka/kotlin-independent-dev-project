package com.bouceka.registration.service

import com.bouceka.models.User
import com.bouceka.registration.dto.CreateRegistrationDto
import com.bouceka.registration.entity.Registration
import com.bouceka.registration.repository.RegistrationRepository
import io.micronaut.http.annotation.Body
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

	fun create(@Body body: CreateRegistrationDto): Registration {
		var newRegistration = Registration(
			UUID.randomUUID(), body.matchDay, body
				.status, body.proficiencyId, body.playerId
		)
		return registrationRepository.save(newRegistration)
	}

	fun delete(id: UUID): Boolean {
		if (registrationRepository.findById(id).isEmpty) return false
		registrationRepository.deleteById(id)
		return true
	}
}
