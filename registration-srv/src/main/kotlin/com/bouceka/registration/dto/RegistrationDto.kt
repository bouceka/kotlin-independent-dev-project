package com.bouceka.registration.dto

import com.bouceka.registration.models.MatchDay
import com.bouceka.registration.models.Status
import java.util.UUID

data class RegistrationDto(
	val matchDay: MatchDay,
	val status: Status,
	val userId: UUID,
	val proficiencyId: UUID,
)

