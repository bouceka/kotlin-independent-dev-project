package com.bouceka.registration.repository

import com.bouceka.registration.entity.Registration
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.repository.PageableRepository
import io.micronaut.data.repository.jpa.JpaSpecificationExecutor
import java.util.*

@JdbcRepository
interface RegistrationRepository  : PageableRepository<Registration, UUID>, JpaSpecificationExecutor<Registration>



