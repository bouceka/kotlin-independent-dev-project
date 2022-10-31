package com.bouceka.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class TeamEntity(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: String,
	val name: String,
	val coordinatorId: String,
	val imageId: String,
	val matchDay: String, // TODO: Create enum
	val season: String, // TODO: Create enum
	val year: String, // maybe INT? most likely not
	val playerLimit: String
)
