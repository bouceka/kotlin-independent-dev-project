package com.bouceka.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import org.bson.types.ObjectId
import java.util.UUID

@MappedEntity
data class TeamEntity(
	@field:Id
	@field:GeneratedValue
	var id: String? = null,
	var teamId: String,
	val name: String,
	val userId: String,
	val imageId: String,
	val matchDay: String, // TODO: Create enum
	val season: String, // TODO: Create enum
	val year: String, // maybe INT? most likely not
	val playerLimit: String
)
