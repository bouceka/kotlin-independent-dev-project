package com.bouceka.models

data class Team(
	val id: String, //TODO: Check if we can use UUID instead
	val name: String,
	val matchDay: String, // TODO: Create enum
	val season: String, // TODO: Create enum
	val year: String, // maybe INT? most likely not
	val playerLimit: String,
	val image: Image,
	val user: User,
)
