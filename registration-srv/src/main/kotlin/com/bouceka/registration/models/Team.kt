package com.bouceka.models

import com.bouceka.registration.models.MatchDay
import com.bouceka.registration.models.Season

data class Team(
	val id: String, //TODO: Check if we can use UUID instead
	val name: String,
	val matchDay: MatchDay, // TODO: Create enum
	val season: Season,
	val year: String, // maybe INT? most likely not
	val playerLimit: String,
	val image: Image,
	val user: User,
)
