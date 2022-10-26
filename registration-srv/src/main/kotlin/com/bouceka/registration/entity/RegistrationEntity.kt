package com.bouceka.registration.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class RegistrationEntity(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: String,
	val matchDay: String,
	val status: String, // TODO: Create enum
	val Player: String,
	val proficiency: String,
)
