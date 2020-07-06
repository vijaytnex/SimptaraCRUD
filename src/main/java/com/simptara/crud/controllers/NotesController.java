package com.simptara.crud.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simptara.crud.exceptions.ItemAlreadyExistException;
import com.simptara.crud.exceptions.ItemNotFoundException;
import com.simptara.crud.models.Notes;
import com.simptara.crud.repositories.NotesRepository;

/**
 * @author vijaydogra
 *
 */
@RestController
public class NotesController extends BaseController {

	@Autowired
	private NotesRepository noteServicee;

	@PostMapping(value = "/notes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody final Notes note) {
		final Optional<Notes> noteInDb = noteServicee.findByName(note.getName());

		if (noteInDb.isPresent()) {
			throw new ItemAlreadyExistException("Note with the provided name already exist.");
		}

		note.setCreationDate(LocalDateTime.now());
		noteServicee.save(note);

	}

	@DeleteMapping("/notes/{id}")
	public void delete(@PathVariable("id") final Integer noteId) {
		final Optional<Notes> note = noteServicee.findById((long) noteId);

		if (!note.isPresent()) {
			throw new ItemNotFoundException(noteId.toString());
		}
		noteServicee.delete(note.get());
	}

	@GetMapping("/notes/{id}")
	public Optional<Notes> findNote(@PathVariable("id") final Integer noteId) {
		final Optional<Notes> note = noteServicee.findById((long) noteId);

		if (!note.isPresent()) {
			throw new ItemNotFoundException(noteId.toString());
		}
		return noteServicee.findById((long) noteId);
	}

	@GetMapping("/notes")
	public Iterable<Notes> showAllNotes() {
		return noteServicee.findAll();
	}

	@PutMapping("/notes/{id}")
	public Optional<Notes> update(@RequestBody final Notes note, @PathVariable("id") final Integer noteId) {
		final Optional<Notes> noteInDb = noteServicee.findById((long) noteId);
		if (!noteInDb.isPresent()) {
			throw new ItemNotFoundException(noteId.toString());
		}

		final Notes noteToUpdate = noteInDb.get();
		noteToUpdate.setName(note.getName());
		noteServicee.save(noteInDb.get());
		return noteServicee.findById((long) noteId);
	}
}
