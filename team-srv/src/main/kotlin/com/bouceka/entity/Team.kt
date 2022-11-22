package com.bouceka.entity

import com.bouceka.models.MatchDay
import com.bouceka.models.Season
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class Team(
	@field:Id
	@field:GeneratedValue
	var id: String? = null,
	var teamId: String,
	val name: String,
	val userId: String,
	val imageId: String,
	val matchDay: MatchDay,
	val season: Season,
	val year: String, // maybe INT? most likely not
	val playerLimit: String
)
