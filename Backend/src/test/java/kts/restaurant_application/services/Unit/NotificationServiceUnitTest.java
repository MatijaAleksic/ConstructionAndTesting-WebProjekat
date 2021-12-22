package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Notification;
import kts.restaurant_application.repositories.NotificationRepository;
import kts.restaurant_application.services.NotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kts.restaurant_application.constants.NotificationConstants.*;
import static kts.restaurant_application.constants.NotificationConstants.DB_WRONG_NOTIFICATION_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class NotificationServiceUnitTest {
    @Autowired
    private NotificationService NotificationService;

    @MockBean
    private NotificationRepository NotificationRepository;

    @Test
    public void testFindAllAdmin() {
        List<Notification> Notifications = new ArrayList<>();

        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification Notification2 = new Notification(DB_NOTIFICATION_TEXT_UNIT1, DB_NOTIFICATION_DATETIME_UNIT1, DB_NOTIFICATION_USER_TYPE_UNIT1);
        Notification Notification3 = new Notification(DB_NOTIFICATION_TEXT_UNIT2, DB_NOTIFICATION_DATETIME_UNIT2, DB_NOTIFICATION_USER_TYPE_UNIT2);
        Notifications.add(Notification);
        Notifications.add(Notification2);
        Notifications.add(Notification3);

        given(NotificationRepository.findAll()).willReturn(Notifications);

        Iterable<Notification> found = NotificationService.findAll("admin");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATION_ADMIN_UNIT, count);
    }

    @Test
    public void testFindAllManager() {
        List<Notification> Notifications = new ArrayList<>();

        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification Notification2 = new Notification(DB_NOTIFICATION_TEXT_UNIT1, DB_NOTIFICATION_DATETIME_UNIT1, DB_NOTIFICATION_USER_TYPE_UNIT1);
        Notification Notification3 = new Notification(DB_NOTIFICATION_TEXT_UNIT2, DB_NOTIFICATION_DATETIME_UNIT2, DB_NOTIFICATION_USER_TYPE_UNIT2);
        Notifications.add(Notification);
        Notifications.add(Notification2);
        Notifications.add(Notification3);

        given(NotificationRepository.findAll()).willReturn(Notifications);

        Iterable<Notification> found = NotificationService.findAll("manager");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATION_MANAGER_UNIT, count);
    }

    @Test
    public void testFindAllCook() {
        List<Notification> Notifications = new ArrayList<>();

        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification Notification2 = new Notification(DB_NOTIFICATION_TEXT_UNIT1, DB_NOTIFICATION_DATETIME_UNIT1, DB_NOTIFICATION_USER_TYPE_UNIT1);
        Notification Notification3 = new Notification(DB_NOTIFICATION_TEXT_UNIT3, DB_NOTIFICATION_DATETIME_UNIT3, DB_NOTIFICATION_USER_TYPE_UNIT3);
        Notifications.add(Notification);
        Notifications.add(Notification2);
        Notifications.add(Notification3);

        given(NotificationRepository.findAll()).willReturn(Notifications);

        Iterable<Notification> found = NotificationService.findAll("cook");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATION_COOK_UNIT, count);
    }

    @Test
    public void testFindAllMainCook() {
        List<Notification> Notifications = new ArrayList<>();

        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification Notification2 = new Notification(DB_NOTIFICATION_TEXT_UNIT1, DB_NOTIFICATION_DATETIME_UNIT1, DB_NOTIFICATION_USER_TYPE_UNIT1);
        Notification Notification3 = new Notification(DB_NOTIFICATION_TEXT_UNIT4, DB_NOTIFICATION_DATETIME_UNIT4, DB_NOTIFICATION_USER_TYPE_UNIT4);
        Notifications.add(Notification);
        Notifications.add(Notification2);
        Notifications.add(Notification3);

        given(NotificationRepository.findAll()).willReturn(Notifications);

        Iterable<Notification> found = NotificationService.findAll("maincook");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATION_MAINCOOK_UNIT, count);
    }

    @Test
    public void testFindAllBarman() {
        List<Notification> Notifications = new ArrayList<>();

        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification Notification2 = new Notification(DB_NOTIFICATION_TEXT_UNIT1, DB_NOTIFICATION_DATETIME_UNIT1, DB_NOTIFICATION_USER_TYPE_UNIT1);
        Notification Notification3 = new Notification(DB_NOTIFICATION_TEXT_UNIT5, DB_NOTIFICATION_DATETIME_UNIT5, DB_NOTIFICATION_USER_TYPE_UNIT5);
        Notifications.add(Notification);
        Notifications.add(Notification2);
        Notifications.add(Notification3);

        given(NotificationRepository.findAll()).willReturn(Notifications);

        Iterable<Notification> found = NotificationService.findAll("barman");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATION_BARMAN_UNIT, count);
    }

    @Test
    public void testFindAllMainWaiter() {
        List<Notification> Notifications = new ArrayList<>();

        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification Notification2 = new Notification(DB_NOTIFICATION_TEXT_UNIT1, DB_NOTIFICATION_DATETIME_UNIT1, DB_NOTIFICATION_USER_TYPE_UNIT1);
        Notification Notification3 = new Notification(DB_NOTIFICATION_TEXT_UNIT6, DB_NOTIFICATION_DATETIME_UNIT6, DB_NOTIFICATION_USER_TYPE_UNIT6);
        Notifications.add(Notification);
        Notifications.add(Notification2);
        Notifications.add(Notification3);

        given(NotificationRepository.findAll()).willReturn(Notifications);

        Iterable<Notification> found = NotificationService.findAll("waiter");

        int count = 0;
        for(Notification u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_NOTIFICATION_WAITER_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(NotificationRepository.findById(DB_WRONG_NOTIFICATION_ID))
                .willThrow(ResponseStatusException.class);

        NotificationService.findOne(DB_WRONG_NOTIFICATION_ID);
    }

    @Test
    public void testFindOne() {
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification.setId(DB_NOTIFICATION_ID);

        Mockito.when(NotificationRepository.findById(DB_NOTIFICATION_ID))
                .thenReturn(java.util.Optional.of(Notification));

        Notification found = NotificationService.findOne(DB_NOTIFICATION_ID);
        assertEquals(DB_NOTIFICATION_ID, found.getId());
    }

    @Test
    public void testSave(){
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);

        given(NotificationRepository.save(Notification)).willReturn(Notification);

        Notification created = NotificationService.save(Notification);

        assertEquals(NEW_NOTIFICATION_TEXT, created.getText());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification.setId(DB_NOTIFICATION_ID);

        Mockito.when(NotificationRepository.findById(DB_NOTIFICATION_ID)).thenThrow(ResponseStatusException.class);

        boolean Notification1 = NotificationService.delete(DB_NOTIFICATION_ID);
    }

    @Test
    public void testDelete1(){
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification.setId(DB_NOTIFICATION_ID);

        Mockito.when(NotificationRepository.findById(DB_NOTIFICATION_ID)).thenReturn(Optional.of(Notification));

        boolean Notification1 = NotificationService.delete(DB_NOTIFICATION_ID);

        assertTrue(Notification1);
    }



    @Test
    public void testDelete2(){
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification.setId(DB_NOTIFICATION_ID);

        given(NotificationRepository.findById(DB_NOTIFICATION_ID)).willReturn(java.util.Optional.of(Notification));

        boolean tested_NOTIFICATION = NotificationService.delete(Notification);
        assertTrue(tested_NOTIFICATION);
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Notification Notification = new Notification(NEW_NOTIFICATION_TEXT, NEW_NOTIFICATION_DATETIME, NEW_NOTIFICATION_USER_TYPE);
        Notification.setId(DB_WRONG_NOTIFICATION_ID);

        Mockito.when(NotificationRepository.findById(DB_WRONG_NOTIFICATION_ID)).thenThrow(ResponseStatusException.class);
        doNothing().when(NotificationRepository).delete(Notification);


        boolean tested_NOTIFICATION = NotificationService.delete(Notification);
    }
}
