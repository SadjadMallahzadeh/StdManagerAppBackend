package com.sadjadmallahzadeh.stdmanagerappbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class StdManagerAppBackend

	fun main(args: Array<String>) {
		runApplication<StdManagerAppBackend>(*args)
	}
