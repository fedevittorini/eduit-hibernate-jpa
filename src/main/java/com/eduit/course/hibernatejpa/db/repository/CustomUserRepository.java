package com.eduit.course.hibernatejpa.db.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.eduit.course.hibernatejpa.db.entity.UserEntity;

@Repository
public class CustomUserRepository {

    private static Logger LOG = LoggerFactory
    	      .getLogger(CustomUserRepository.class);
    
	private EntityManager em;
	
	private PasswordEncoder pe;
	
	public CustomUserRepository(EntityManager em, PasswordEncoder pe) {
		this.em = em;
		this.pe = pe;
	}
	
	@Transactional
	public Optional<UserEntity> createUserWithSQL(UserEntity user) {

		String sql = "INSERT INTO users (username, first_name, last_name, email, password, date_created) VALUES (:username, :firstName, :lastName, :email, :password, :dateCreated)";
		try {
			Query query = em.createNativeQuery(sql);
			query.setParameter("username", user.getUsername());
			query.setParameter("firstName", user.getFirstName());
			query.setParameter("lastName", user.getLastName());
			query.setParameter("email", user.getEmail());
			query.setParameter("password", user.getPassword());
			query.setParameter("dateCreated", user.getDateCreated());
			Integer rs = query.executeUpdate();
			return getUserByIdWithCriteria(rs.longValue());
		} catch (Exception e) {
			LOG.error("Error en SQL", e);
		}
		
		return Optional.ofNullable(null);
	}

	public Optional<UserEntity> login(String username, String password) {
		
		String sql = "SELECT u FROM UserEntity u WHERE username = '"+username+"'";
		try {
			UserEntity ret = em.createQuery(sql, UserEntity.class)
			.getSingleResult();
			if (pe.matches(password, ret.getPassword())) {
				return Optional.of(ret);
			}			
		} catch (Exception e) {
		}
		
		return Optional.ofNullable(null);
	}
	
	
	public Optional<UserEntity> getUserByIdWithCriteria(Long id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<UserEntity> qc = builder.createQuery(UserEntity.class);
		
		Root<UserEntity> from = qc.from(UserEntity.class);
		
		qc.where(builder.equal(from.get("id"), id));
		
		UserEntity ue = em.createQuery(qc).getSingleResult();
		
		return Optional.ofNullable(ue);
		
	}


}
