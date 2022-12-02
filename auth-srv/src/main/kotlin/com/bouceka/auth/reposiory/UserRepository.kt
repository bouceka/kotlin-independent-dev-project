package com.bouceka.auth.reposiory

import com.bouceka.auth.entity.User
import io.micronaut.data.annotation.Query
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor
import java.util.*

@JdbcRepository(dialect = Dialect.POSTGRES)
interface UserRepository  : PageableRepository<User, UUID> {

	@Query("select * from public.user where email=:email")
	fun findByEmail(email:String): User?
}
