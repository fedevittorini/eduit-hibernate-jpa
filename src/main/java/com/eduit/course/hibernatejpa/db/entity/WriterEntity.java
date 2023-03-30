package com.eduit.course.hibernatejpa.db.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = WriterEntity.TABLE_NAME)
/**
 * This class is mean to represent the database {@link ProductEntity.TABLE_NAME} table.
 * 
 * @author Federico Vittorini.
 *
 */
public class WriterEntity {

	public static final String TABLE_NAME = "writers";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * This is the entity id.
	 * If this attribute is null, that means the entity is not persisted yet.
	 */
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToMany()
	@JoinTable(name="books_writers",
	joinColumns = { @JoinColumn (name = "writer_id" )},
	inverseJoinColumns = { @JoinColumn (name = "book_id" )})
	private Set<BookEntity> books;
	
	/**
	 * This is the default empty class constructor required by Hibernate. 
	 */
	public WriterEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
