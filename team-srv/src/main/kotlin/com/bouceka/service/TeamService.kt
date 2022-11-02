package com.bouceka.service

import com.bouceka.dto.TeamDto
import com.bouceka.entity.TeamEntity
import com.bouceka.exceptions.TeamNotFound
import com.bouceka.repository.TeamRepository
import io.micronaut.http.annotation.Body
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import java.net.http.HttpResponse
import java.util.*

@Singleton
class TeamService(private val teamRepository: TeamRepository) {

	fun findAll(): List<TeamEntity> {
		return teamRepository.findAll().toList()
	}

	fun findById(id: String): Optional<TeamEntity> {
		return teamRepository.findById(id)
	}

	fun create(@Body body: TeamDto): TeamEntity {
		val newTeam = TeamEntity(
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

	fun update(id: String, body: TeamDto): TeamEntity {
		val foundTeam = teamRepository.findById(id)

		if (foundTeam.isEmpty)
			throw ClassNotFoundException("Team with id $id was not found")

		return teamRepository.update(
			TeamEntity(
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

	fun delete(id: String): Optional<TeamEntity> {
		val foundTeam = teamRepository.findById(id)

		if (foundTeam.isEmpty)
			throw TeamNotFound()

		teamRepository.deleteById(id)
		return foundTeam
	}

}
