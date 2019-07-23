package com.m3.training.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.m3.training.SQLObject.Country;

class CountryDAOTest {
	CountryDAO countryDAOUnderTesting;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		countryDAOUnderTesting = new CountryDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void test_CountryDAOTest_getFotNotExistID() {
		long id = 9999;
		String msg="Data base returns calue by id " + id +" even though it is not in database";
		Optional<Country> actual = countryDAOUnderTesting.getForID(id);
		boolean expected = false;
		assertEquals(expected, actual.isPresent(), msg);
	}
	
	@Test
	void test_CountryDAOTest_createNewCountry(){
		long id = 999;
		String name = "daven";
		Country country = new Country();
		country.setCountry(name);
		country.setCountry_id(id);
		countryDAOUnderTesting.create(country);
		Optional<Country> actual = countryDAOUnderTesting.getForID(id);
		boolean expected = true;
		String msg="Fail to create the new country with id = " + id;
		assertEquals(expected, actual.isPresent(), msg);
	}
	
	@Test 
	void test_CountryDAOTest_deleteCountryById() {
		long id = 999;
		countryDAOUnderTesting.remove(id);
		Optional<Country> actual = countryDAOUnderTesting.getForID(id);
		boolean expected = false;
		String msg="Fail to delete the new country with id = " + id;
		assertEquals(expected, actual.isPresent(), msg);
	}
	

}
