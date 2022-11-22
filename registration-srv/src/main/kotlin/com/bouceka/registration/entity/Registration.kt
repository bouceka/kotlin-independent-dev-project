package com.bouceka.registration.entity

import com.bouceka.registration.models.MatchDay
import com.bouceka.registration.models.Status
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.util.UUID

@MappedEntity
data class Registration(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: UUID,
	var matchDay: MatchDay,
	var status: Status,
	var proficiency_id: UUID,
	var user_id: UUID,
)
