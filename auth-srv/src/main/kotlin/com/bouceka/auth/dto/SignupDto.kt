package com.bouceka.auth.dto

data class SignupDto(
	val email: String,
	val firstName: String,
	val lastName: String,
	val password: String,
	val phoneNumber: String,
	val schoolNumber: String,
	val gender: String,
	val dateOfBirth: String,
	val notes: String,
	val role: String
)
