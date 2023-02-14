package com.eduit.course.hibernatejpa.db.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = CartEntity.TABLE_NAME)
/**
 * This class is mean to represent the database {@link ProductEntity.TABLE_NAME} table.
 * 
 * @author Federico Vittorini.
 *
 */
public class CartEntity {

	
	public static final String TABLE_NAME = "carts";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * This is the entity id.
	 * If this attribute is null, that means the entity is not persisted yet.
	 */
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private UserEntity user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<CartDetailEntity> details;

	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "date_deleted", nullable = true)
	private Date dateDeleted;
	
	/**
	 * This is the default empty class constructor required by Hibernate. 
	 */
	public CartEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Set<CartDetailEntity> getDetails() {
		return details;
	}

	public void setDetails(Set<CartDetailEntity> details) {
		this.details = details;
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
