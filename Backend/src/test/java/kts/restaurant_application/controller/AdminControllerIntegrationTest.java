package kts.restaurant_application.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import kts.restaurant_application.constants.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kts.restaurant_application.model.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class AdminControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAllAdmins() {
		ResponseEntity<Admin[]> responseEntity = restTemplate
				.getForEntity("/admins", Admin[].class);

		Admin[] categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(Constants.NUM_OF_ADMINS, categories.length);
		assertEquals(Constants.ADMIN_USERNAME, categories[0].getUsername());
	}

	// @Test
	// public void testUpdateAdmin() {
	// 	ResponseEntity<Admin[]> responseEntity = restTemplate.getForEntity(
	// 			"/api/cultural-content-category/by-page?page=0&size=2", Admin[].class);

	// 	Admin[] categories = responseEntity.getBody();

	// 	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	// 	assertEquals(FIND_ALL_NUMBER_OF_ITEMS, categories.length);
	// 	assertEquals(DB_CATEGORY, categories[0].getUsername());
	// }

	@Test
	public void testGetAdmin() {
		ResponseEntity<Admin> responseEntity = restTemplate
				.getForEntity("/admins/1", Admin.class);

		Admin category = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(category);
		assertEquals(Constants.ADMIN_USERNAME, category.getUsername());
	}

	// @Test
	// public void testDeleteAdmin() throws Exception {
	// 	ResponseEntity<CategoryTypeDTO[]> responseEntity = restTemplate
	// 			.getForEntity("/api/cultural-content-category/1/category-types", CategoryTypeDTO[].class);

	// 	CategoryTypeDTO[] types = responseEntity.getBody();

	// 	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	// 	assertEquals(FIND_ALL_NUMBER_OF_ITEMS, types.length);
	// 	assertEquals(DB_CATEGORY_TYPE, types[0].getUsername());
	// }
}
