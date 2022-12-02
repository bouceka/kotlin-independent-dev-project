package com.bouceka.auth.entity

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.util.UUID

@MappedEntity
data class User(
	@field:Id
	@field:GeneratedValue(GeneratedValue.Type.UUID)
	var id: UUID,
	val email:String,
	val firstName:String,
	val lastName:String,
	val password:String,
	val phoneNumber:String,
	val schoolNumber:String,
	val gender:String,
	val dateOfBirth:String,
	val notes:String,
	val role:String,
)
