package com.m3.training.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m3.training.SQLObject.Country;

public class CountryDAO implements CRUD<Country> {

	private final EntityManager em;
		
	public CountryDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-connection");
		em = emf.createEntityManager();
	}
		
	@Override
	public Optional<Country> getForID(long id) {
		Optional<Country> optionalCountry = Optional.ofNullable(this.em.find(Country.class, id));
		return optionalCountry;
	}

	@Override
	public void create(Country country) {
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
	}

	@Override
	public void update(Country country) {
		em.getTransaction().begin();
		em.merge(country);
		em.getTransaction().commit();
	}

	@Override
	public void remove(long id) {
		em.getTransaction().begin();
		this.getForID(id).ifPresent(em::remove);
		em.getTransaction().commit();
	}

	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
