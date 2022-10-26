package com.bouceka.player.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class PlayerEntity(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: String,
	var notes: String,
	var userId: String
)
