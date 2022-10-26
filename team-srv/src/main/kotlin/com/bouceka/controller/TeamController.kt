package com.bouceka.team.controller

import com.bouceka.models.Team
import com.bouceka.models.User
import com.bouceka.player.dto.UpdateTeamDto
import com.bouceka.player.models.Coordinator
import com.bouceka.player.models.Image
import io.micronaut.http.annotation.*

@Controller("/api/team")
class TeamController {

	val imageMock = Image("1", "1", "profile image", "default image", "url")
	val userMock = User("1", "John", "Doe", "john@doe.com", "password", "123456789", "123456", "Player")
	val coordinatorMock = Coordinator("1", "Caption", userMock)
	val teamListMock: List<Team> =
		listOf(
			Team("1", "Women's Volleyball", "Tuesday", "Spring", "2023", "9", imageMock, coordinatorMock),
			Team("2", "Men's Volleyball", "Wednesday", "Spring", "2023", "9", imageMock, coordinatorMock)
		)

	@Get
	fun findAll(): List<Team> {
		return teamListMock
	}

	@Get("/{id}")
	fun findById(@PathVariable id: String): Team? {
		return teamListMock.find { it.id == id }
	}

	/*
	@Put("/{id}")
	fun update(
		@PathVariable id: String,
		@Body request: UpdateTeamDto
	): Team?  {
		var (name, matchDay, season, year, playerLimit) = request
		var foundTeam = teamListMock.find { it.id == id }
		if(foundTeam != null) return null
		foundTeam = teamListMock.find { it.id == id }.let { teamListMock[index] = }

		return foundTeam
	} */
}

