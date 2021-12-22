package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

public class WaiterConstants {

    public static final int FIND_ALL_NUMBER_OF_WAITERS= 2;

    public static final Long DB_WAITER_ID= 12L;
    public static final Long DB_WRONG_WAITER_ID= 100L;

    public static final String DB_WAITER_FIRSTNAME ="Pera";
    public static final String DB_WAITER_LASTNAME ="Peric";
    public static final String DB_WAITER_USERNAME = "ognjen@maildrop.cc";
    public static final String DB_WAITER_PASSWORD = "ognjen";
    public static final Date DB_WAITER_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 12);
    public static final Long DB_WAITER_SALARY = 20000L;
    public static final Boolean DB_WAITER_IS_DELETED = false;



    public static final String NEW_WAITER_FIRSTNAME ="FIRSTNAME1";
    public static final String NEW_WAITER_LASTNAME ="LASTNAME1";
    public static final String NEW_WAITER_USERNAME = "USERNAME1";
    public static final String NEW_WAITER_PASSWORD = "PASSWORD1";
    public static final Date NEW_WAITER_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);
    public static final Long NEW_WAITER_SALARY = 15000L;
    public static final Boolean NEW_WAITER_IS_DELETED = false;
}
