package com.bouceka.dto

import com.bouceka.models.MatchDay
import com.bouceka.models.Season
import io.micronaut.core.annotation.Introspected


@Introspected
data class TeamDto(
	val name: String,
	val userId: String,
	val imageId: String,
	val matchDay: MatchDay,
	val season: Season,
	val year: String, // maybe INT? most likely not
	val playerLimit: String
)
