package com.bouceka.registration.models

data class Registration(
	var id: String,
	val matchDay: String,
	val status: String, // TODO: Create enum
	val proficiency: String,
	val Player: Player,
)
