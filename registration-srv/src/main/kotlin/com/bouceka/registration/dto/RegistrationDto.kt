package com.bouceka.registration.dto

import java.util.UUID

data class CreateRegistrationDto(
	val matchDay: String,
	val status: String,
	val playerId: UUID,
	val proficiencyId: UUID,
)

