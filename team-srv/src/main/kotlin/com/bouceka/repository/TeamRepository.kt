package com.bouceka.repository

import com.bouceka.entity.TeamEntity
import io.micronaut.data.mongodb.annotation.*
import io.micronaut.data.repository.CrudRepository

@MongoRepository(databaseName = "team")
interface TeamRepository : CrudRepository<TeamEntity, String> {
}
