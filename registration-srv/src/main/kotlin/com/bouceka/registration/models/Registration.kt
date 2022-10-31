package com.bouceka.registration.models

import com.bouceka.models.User

data class Registration(
	var id: String,
	var matchDay: String,
	var status: String, // TODO: Create enum
	var proficiency: String,
	var user: User,
)
