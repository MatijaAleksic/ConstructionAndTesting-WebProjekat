package kts.restaurant_application.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.constants.Constants;
import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.User;
import kts.restaurant_application.services.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserControllerUnitTest {

    @Autowired
	private TestRestTemplate restTemplate;

    @MockBean
    private UserService userService;

    @Test
    public void testCreate() throws Exception {
      User newAdmin = new User(100L, 0L, "a", "a", "uniqueUsername123", "123", new Date(), 100l, false);
        Mockito.when(userService.save(newAdmin)).thenReturn(newAdmin).thenThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
      ResponseEntity<User> responseEntity = restTemplate.postForEntity(
				"/users", newAdmin, User.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    responseEntity = restTemplate.postForEntity(
      "/users", newAdmin, User.class);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

    }

    @Test
    public void testDelete() throws Exception {
        User us = new User();
        us.setIsDeleted(true);
        Mockito.when(this.userService.delete(1l)).thenReturn(us).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        Mockito.when(this.userService.delete(999l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
      ResponseEntity<User> responseEntity = restTemplate.postForEntity(
				"/users/delete/1", 1, User.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());
      User user = responseEntity.getBody();
        assert user != null;
        assertEquals(user.getIsDeleted(), null);
      responseEntity = restTemplate.postForEntity(
				"/users/delete/999", 999, User.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());

    }

    @Test
    public void testFindAll() {
        ArrayList<User> users = new ArrayList<>();
        Admin admin = new Admin();
        admin.setUsername("admin@gmail.com");
        users.add(admin);

        for(int i = 1; i < Constants.NUM_OF_USERS; i++){
            users.add(new User());
        }
        Mockito.when(this.userService.findAll()).thenReturn(users);
        ResponseEntity<User[]> responseEntity = restTemplate
				.getForEntity("/users/", User[].class);

        User[] categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assert categories != null;
        assertEquals(Constants.NUM_OF_USERS, categories.length);
		assertEquals(Constants.ADMIN_USERNAME, categories[0].getUsername());
    }

    @Test
    public void testFindOne() {
        Admin admin = new Admin();
        admin.setUsername("admin@gmail.com");
        Mockito.when(this.userService.findOne(1l)).thenReturn(admin);
        ResponseEntity<User> responseEntity = restTemplate
				.getForEntity("/users/1", User.class);

		User category = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(category);
		assertEquals(Constants.ADMIN_USERNAME, category.getUsername());
    }

    @Test
    public void testUpdate() throws Exception {
        User newAdmin = new User(1L, 0L, "ime1", "a", "markoMarkovic@maildrop.cc", "123", new Date(), 100L, false);
		Mockito.when(this.userService.update(newAdmin)).thenReturn(newAdmin);
		ResponseEntity<User> responseEntity = restTemplate.postForEntity(
				"/users/update", newAdmin, User.class);

        User response = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assert response != null;
        assertEquals(newAdmin.getUsername(), response.getUsername());

        User newAdmin2 = new User(1L, 0L, "ime2", "a", "markoMarkovic@maildrop.cc", "123", new Date(), 100L, false);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Mockito.when(this.userService.update(newAdmin2)).thenReturn(newAdmin2);

        responseEntity = restTemplate.postForEntity(
				"/users/update", newAdmin2, User.class);
        User response2 = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assert response2 != null;
        assertNotEquals(response2.getFirstName(), response.getFirstName());

        User newAdmin3 = new User(50L, 0L, "a", "a", "uniqueUsername1234", "123", new Date(), 100L, false);
		Mockito.when(this.userService.update(newAdmin3)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        responseEntity = restTemplate.postForEntity(
				"/users/update", newAdmin3, User.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    
    }
    
}
