package com.bouceka.team.controller

import com.bouceka.models.Team
import com.bouceka.models.User
import com.bouceka.player.models.Coordinator
import com.bouceka.player.models.Image
import com.bouceka.registration.models.Player
import com.bouceka.registration.models.Registration
import io.micronaut.http.annotation.*

@Controller("/api/registration")
class RegistrationController {

	var userData: User = User("1", "John", "Doe", "john@doe.com", "password", "123456789", "123456", "Player")
	val playerData = Player("1", "", "male", userData)
	val regitrationList = listOf<Registration>(Registration("1", "Tuesday", "Registered", "Competitive", playerData))

	@Get
	fun findAll(): List<Registration> {
		return regitrationList
	}

	@Get("/{id}")
	fun findById(@PathVariable id: String): Registration? {
		return regitrationList.find { it.id == id }
	}

}

