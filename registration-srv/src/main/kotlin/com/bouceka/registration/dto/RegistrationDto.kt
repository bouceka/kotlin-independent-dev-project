package com.bouceka.registration.dto

import java.util.UUID

data class RegistrationDto(
	val matchDay: String,
	val status: String,
	val userId: UUID,
	val proficiencyId: UUID,
)

