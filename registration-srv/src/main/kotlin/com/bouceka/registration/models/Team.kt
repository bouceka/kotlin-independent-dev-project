package com.bouceka.models

import com.bouceka.player.models.Coordinator
import com.bouceka.player.models.Image

data class Team(
	val id: String, //TODO: Check if we can use UUID instead
	val name: String,
	val matchDay: String, // TODO: Create enum
	val season: String, // TODO: Create enum
	val year: String, // maybe INT? most likely not
	val playerLimit: String,
	val image: Image,
	val coordinator: Coordinator,
)
