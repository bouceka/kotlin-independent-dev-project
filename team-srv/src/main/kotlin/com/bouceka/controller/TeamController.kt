package com.bouceka.team.controller

import com.bouceka.dto.TeamDto
import com.bouceka.entity.Team
import com.bouceka.service.TeamService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.Optional

@Controller("/api/team")
class TeamController(private val teamService: TeamService) {

	@Get
	fun findAll(): List<Team> {
		return teamService.findAll()
	}

	@Post
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun create(@Body request: TeamDto): Team {
		return teamService.create(request)
	}

	@Get("/{id}")
	fun findById(@PathVariable id: String): Optional<Team> {
		return teamService.findById(id)
	}


	@Put("/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	fun update(
		@PathVariable id: String,
		@Body request: TeamDto
	): HttpResponse<Team> {
		return HttpResponse.ok(teamService.update(id, request))
	}

	@Delete("/{id}")
	fun delete(@PathVariable id: String): HttpResponse<Optional<Team>> {
		return HttpResponse.ok(teamService.delete(id))
	}
}

