package com.bouceka.auth.service

import com.bouceka.auth.dto.SignupDto
import com.bouceka.auth.entity.User
import com.bouceka.auth.helper.PasswordHelper
import com.bouceka.auth.reposiory.UserRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import jakarta.inject.Singleton
import org.springframework.security.crypto.bcrypt.BCrypt
import java.util.*


@Singleton
class AuthService(private val userRepository: UserRepository) {

	fun signup(@Body body: SignupDto) {
		val findUser = userRepository.findByEmail(body.email)
		if (findUser != null) {
			HttpResponse.badRequest("User already registered")
		}
		val hashedPassword = BCrypt.hashpw(body.password, BCrypt.gensalt())
		var newUser = User(
			id = UUID.randomUUID(),
			email = body.email,
			firstName = body.firstName,
			lastName = body.lastName,
			password = hashedPassword,
			phoneNumber = body.phoneNumber,
			schoolNumber = body.schoolNumber,
			gender = body.gender,
			dateOfBirth = body.dateOfBirth,
			notes = body.notes,
			role = body.role
		)
		userRepository.save(newUser)
	}

	fun findAll(): List<User> {
		return userRepository.findAll().toList()
	}
}
