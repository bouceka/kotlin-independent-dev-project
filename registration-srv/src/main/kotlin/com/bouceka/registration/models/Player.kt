package com.bouceka.registration.models

import com.bouceka.models.User

data class Player(
	val id: String,
	val notes: String,
	val gender: String, // TODO: Create enum
	val user: User
)
