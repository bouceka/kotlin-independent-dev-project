package com.bouceka.registration.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.util.UUID

@MappedEntity
data class Registration(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: UUID,
	var matchDay: String,
	var status: String, // TODO: Create enum
	var proficiency_id: UUID,
	var user_id: UUID,
)
