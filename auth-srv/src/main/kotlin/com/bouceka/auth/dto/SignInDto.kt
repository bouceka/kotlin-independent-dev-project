package com.bouceka.auth.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class SignInDto(
	val email: String,
	val password: String
)
