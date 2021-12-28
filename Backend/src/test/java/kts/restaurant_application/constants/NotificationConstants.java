package kts.restaurant_application.constants;

import kts.restaurant_application.model.State;
import kts.restaurant_application.model.UserTypes;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class NotificationConstants {

    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_ADMIN = 3;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_MANAGER = 2;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_COOK = 2;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_MAINCOOK = 2;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_BARMAN = 2;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_WAITER = 2;

    public static final Long DB_NOTIFICATION_ID= 1L;
    public static final Long DB_WRONG_NOTIFICATION_ID= 100L;

    public static final String DB_NOTIFICATION_TEXT = "Notifikacija1";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME=  LocalDateTime.of(2012, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE= UserTypes.maincook;


    public static final String NEW_NOTIFICATION_TEXT = "Notifikacija1";
    public static final LocalDateTime NEW_NOTIFICATION_DATETIME=  LocalDateTime.of(2016, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes NEW_NOTIFICATION_USER_TYPE= UserTypes.cook;

    public static final Long NEW_NOTIFICATION_ID= 14L;

    public static final String DB_NOTIFICATION_TEXT_UNIT1 = "NOTIFICATION1";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME_UNIT1=  LocalDateTime.of(2015, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE_UNIT1= UserTypes.admin;

    public static final String DB_NOTIFICATION_TEXT_UNIT2 = "NOTIFICATION2";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME_UNIT2=  LocalDateTime.of(2015, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE_UNIT2= UserTypes.manager;

    public static final String DB_NOTIFICATION_TEXT_UNIT3 = "NOTIFICATION2";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME_UNIT3=  LocalDateTime.of(2015, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE_UNIT3= UserTypes.cook;

    public static final String DB_NOTIFICATION_TEXT_UNIT4 = "NOTIFICATION2";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME_UNIT4=  LocalDateTime.of(2015, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE_UNIT4= UserTypes.maincook;

    public static final String DB_NOTIFICATION_TEXT_UNIT5 = "NOTIFICATION2";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME_UNIT5=  LocalDateTime.of(2015, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE_UNIT5= UserTypes.barman;

    public static final String DB_NOTIFICATION_TEXT_UNIT6 = "NOTIFICATION2";
    public static final LocalDateTime DB_NOTIFICATION_DATETIME_UNIT6=  LocalDateTime.of(2015, Month.DECEMBER, 12, 11,11,11);
    public static final UserTypes DB_NOTIFICATION_USER_TYPE_UNIT6= UserTypes.waiter;

    public static final int FIND_ALL_NUMBER_OF_NOTIFICATION_ADMIN_UNIT = 1;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATION_MANAGER_UNIT = 1;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATION_COOK_UNIT = 2;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATION_MAINCOOK_UNIT = 1;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATION_BARMAN_UNIT = 1;
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATION_WAITER_UNIT = 1;

    public static final int DB_SAVED_ITEM_ID_UNIT= 2;
    public static final Boolean DB_ITEM_IS_DELETED_UNIT = true;
}
