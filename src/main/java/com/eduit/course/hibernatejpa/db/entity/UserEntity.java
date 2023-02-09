package com.eduit.course.hibernatejpa.db.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = UserEntity.TABLE_NAME)
/**
 * This class is mean to represent the database {@link ProductEntity.TABLE_NAME} table.
 * 
 * @author Federico Vittorini.
 *
 */
public class UserEntity {

	public static final String TABLE_NAME = "users";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * This is the entity id.
	 * If this attribute is null, that means the entity is not persisted yet.
	 */
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
		
	@Column(nullable = false)
	private String password;
	
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "date_deleted", nullable = true)
	private Date dateDeleted;
	
	/**
	 * This is the default empty class constructor required by Hibernate. 
	 */
	public UserEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Set the given password to the user.
	 * 
	 * @param password the Password, It cannot be null or blank and should be between 6 an 12 chars.
	 */
	public void setPassword(String password) {
		if (password.length() < 6 || password.length() > 12 ) {
			throw new IllegalArgumentException("The password length should be between 6 an 12 chars length");
		}
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	
	
}
