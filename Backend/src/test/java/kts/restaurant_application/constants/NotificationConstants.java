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
    public static final int FIND_ALL_NUMBER_OF_NOTIFICATIONS_COOK = 3;
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
}
