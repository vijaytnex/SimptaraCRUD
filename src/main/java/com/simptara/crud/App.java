package com.simptara.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.simptara.crud.repositories.NotesRepository;

/**
 * @author vijaydogra
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = { NotesRepository.class })
public class App extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}
}