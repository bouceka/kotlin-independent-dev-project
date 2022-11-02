package com.bouceka.dto

import io.micronaut.core.annotation.Introspected


@Introspected
data class TeamDto(
	val name: String,
	val userId: String,
	val imageId: String,
	val matchDay: String, // TODO: Create enum
	val season: String, // TODO: Create enum
	val year: String, // maybe INT? most likely not
	val playerLimit: String
)
