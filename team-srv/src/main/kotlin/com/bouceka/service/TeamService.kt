package com.bouceka.service

import com.bouceka.dto.TeamDto
import com.bouceka.entity.Team
import com.bouceka.errors.BadRequestError
import com.bouceka.errors.GlobalException
import com.bouceka.errors.NotFoundError
import com.bouceka.errors.RequestValidationError
import com.bouceka.repository.TeamRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import java.util.*

@Singleton
class TeamService(private val teamRepository: TeamRepository) {

	fun findAll(): List<Team> {
		return teamRepository.findAll().toList()
	}

	fun findById(id: String): Optional<Team> {
		return teamRepository.findById(id)
	}

	fun create(@Body body: TeamDto): Team {
		val newTeam = Team(
			teamId = UUID.randomUUID().toString(),
			name = body.name,
			userId = UUID.randomUUID().toString(),
			imageId = UUID.randomUUID().toString(),
			matchDay = body.matchDay,
			season = body.season,
			year = body.year,
			playerLimit = body.playerLimit
		)
		teamRepository.save(newTeam)
		return newTeam
	}

	fun update(id: String, body: TeamDto): Team {
		val foundTeam = teamRepository.findById(id)

		if (foundTeam.isEmpty)
			throw BadRequestError("Team not found")

		return teamRepository.update(
			Team(
				id,
				teamId = UUID.randomUUID().toString(),
				name = body.name,
				userId = UUID.randomUUID().toString(),
				imageId = UUID.randomUUID().toString(),
				matchDay = body.matchDay,
				season = body.season,
				year = body.year,
				playerLimit = body.playerLimit
			)
		)

	}

	fun delete(id: String): Optional<Team> {
		if (!ObjectId.isValid(id)) throw RequestValidationError("Invalid Object Id")

		val foundTeam = teamRepository.findById(id)
		if (teamRepository.findById(id).isEmpty)
			throw NotFoundError()

		teamRepository.deleteById(id)
		return foundTeam
	}

}
