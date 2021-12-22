package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Notification;
import kts.restaurant_application.services.NotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.NotificationConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class NotificationServiceIntegrationTest {

    @Autowired
    private NotificationService notificationService;

    @Test
    public void testFindAllAdmin() {
        Iterable<Notification> found = notificationService.findAll("admin");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATIONS_ADMIN, count);
    }

    @Test
    public void testFindAllManager() {
        Iterable<Notification> found = notificationService.findAll("manager");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATIONS_MANAGER, count);
    }

    @Test
    public void testFindAllCook() {
        Iterable<Notification> found = notificationService.findAll("cook");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATIONS_COOK, count);
    }

    @Test
    public void testFindAllMainCook() {
        Iterable<Notification> found = notificationService.findAll("maincook");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATIONS_MAINCOOK, count);
    }

    @Test
    public void testFindAllBarman() {
        Iterable<Notification> found = notificationService.findAll("barman");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATIONS_BARMAN, count);
    }

    @Test
    public void testFindAllWaiter() {
        Iterable<Notification> found = notificationService.findAll("waiter");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATIONS_WAITER, count);
    }



    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        notificationService.findOne(DB_WRONG_NOTIFICATION_ID);
    }

    @Test
    public void testFindOne() {
        Notification found = notificationService.findOne(DB_NOTIFICATION_ID);
        assertEquals(DB_NOTIFICATION_ID, found.getId());
    }

    @Test
    public void testSave(){
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);

        Notification created = notificationService.save(Notification);

        assertEquals(NEW_NOTIFICATION_ID, created.getId());
    }

    @Test
    public void testDelete1(){
        boolean flag = notificationService.delete(DB_NOTIFICATION_ID);
        assertTrue(flag);
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldThrowResponseStatusException(){
        boolean flag = notificationService.delete(DB_WRONG_NOTIFICATION_ID);
    }

    @Test
    public void testDelete2(){
        Notification Notification = new Notification(DB_NOTIFICATION_TEXT, DB_NOTIFICATION_DATETIME, DB_NOTIFICATION_USER_TYPE);
        Notification.setId(DB_NOTIFICATION_ID + 1);

        boolean flag = notificationService.delete(Notification);
        assertTrue(flag);
    }
}
