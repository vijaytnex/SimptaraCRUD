package com.simptara.crud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.simptara.crud.models.Notes;

/**
 * @author vijaydogra
 *
 */
public interface NotesRepository extends JpaRepository<Notes, Long>, JpaSpecificationExecutor<Notes> {

	Optional<Notes> findByName(String name);

}
