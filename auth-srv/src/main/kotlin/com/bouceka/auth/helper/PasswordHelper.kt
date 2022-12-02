package com.bouceka.auth.helper

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import jakarta.inject.Singleton

@Singleton
class PasswordHelper {
	private val encoder = BCryptPasswordEncoder()

	fun encodePwd(input: String): String {
		return encoder.encode(input)
	}

	fun passwordValid(input: String, hashPwd: String): Boolean {
		return encoder.matches(input, hashPwd)
	}
}
