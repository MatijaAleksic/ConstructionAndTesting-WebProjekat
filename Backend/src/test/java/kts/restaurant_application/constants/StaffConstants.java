package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

public class StaffConstants {

    public static final int FIND_ALL_NUMBER_OF_STAFFS= 6;

    public static final Long DB_STAFF_ID= 5L;
    public static final Long DB_WRONG_STAFF_ID= 100L;
    public static final Long DB_STAFF_ID_DELETE= 2L;


    public static final String DB_STAFF_FIRSTNAME ="Pera";
    public static final String DB_STAFF_LASTNAME ="Peric";
    public static final String DB_STAFF_USERNAME = "pavlepavlovic@maildrop.cc";
    public static final String DB_STAFF_PASSWORD = "peraperic";
    public static final Date DB_STAFF_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 12);
    public static final Long DB_STAFF_SALARY = 20000L;
    public static final Boolean DB_STAFF_IS_DELETED = false;

    public static final int FIND_ALL_NUMBER_OF_ITEMS = 1;


    public static final String NEW_STAFF_FIRSTNAME ="FIRSTNAME1";
    public static final String NEW_STAFF_LASTNAME ="LASTNAME1";
    public static final String NEW_STAFF_USERNAME = "USERNAME1";
    public static final String NEW_STAFF_PASSWORD = "PASSWORD1";
    public static final Date NEW_STAFF_DATE_OF_BIRTH = new Date(2015, Calendar.DECEMBER, 11);
    public static final Long NEW_STAFF_SALARY = 9999L;
    public static final Boolean NEW_STAFF_IS_DELETED = false;
}