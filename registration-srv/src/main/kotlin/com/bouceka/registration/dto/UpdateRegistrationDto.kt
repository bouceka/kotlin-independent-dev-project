package com.bouceka.player.dto

import io.micronaut.core.annotation.Introspected
import java.util.UUID

@Introspected
class UpdateRegistrationDto(
	val matchDay: String,
	val status: String,
	val player_id: UUID,
	val proficiency_id: UUID,
)
