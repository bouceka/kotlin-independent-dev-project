package com.bouceka.player.dto

import com.bouceka.player.models.Coordinator
import com.bouceka.player.models.Image

class UpdateRegistrationDto(
	val name: String,
	val matchDay: String,
	val season: String,
	val year: String,
	val playerLimit: String,
	val image: Image,
	val coordinator: Coordinator,
) {
}
