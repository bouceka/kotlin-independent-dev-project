package com.bouceka.registration.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class Player(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: String,
	var notes: String,
	var user: String
)
