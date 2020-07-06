package com.simptara.crud.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author vijaydogra
 *
 */

@Entity
@Table(name = "notes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Notes extends BaseModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3655346249683701617L;

	@Column
	private String name;
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	public Notes() {
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final Notes note = (Notes) o;
		return id.equals(note.id) && name.equals(note.name);
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, creationDate);
	}

	public void setCreationDate(final LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + "'}";
	}

}
