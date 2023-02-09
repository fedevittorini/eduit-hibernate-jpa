package com.eduit.course.hibernatejpa.db.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "parent_id")
	private CategoryEntity parent;
	
	@OneToMany(mappedBy = "parent")
	private Set<CategoryEntity> children;
	
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "date_deleted", nullable = true)
	private Date dateDeleted;
	
	public CategoryEntity() { }
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long theId) {
		id = theId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryEntity getParent() {
		return parent;
	}

	public void setParent(CategoryEntity parent) {
		this.parent = parent;
	}

	public Set<CategoryEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<CategoryEntity> children) {
		this.children = children;
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
