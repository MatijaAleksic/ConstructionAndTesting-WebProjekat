package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

public class AdminConstants {


    public static final int FIND_ALL_NUMBER_OF_ADMINS= 3;

    public static final Long DB_ADMIN_ID= 1L;
    public static final Long DB_WRONG_ADMIN_ID= 100L;

    public static final String DB_ADMIN_FIRSTNAME ="Pera";
    public static final String DB_ADMIN_LASTNAME ="Peric";
    public static final String DB_ADMIN_USERNAME = "markoMarkovic@maildrop.cc";
    public static final String DB_ADMIN_PASSWORD = "MarkoMarkovic12";
    public static final Date DB_ADMIN_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 12);
    public static final Long DB_ADMIN_SALARY = 20000L;
    public static final Boolean DB_ADMIN_IS_DELETED = false;



    public static final String NEW_ADMIN_FIRSTNAME ="FIRSTNAME1";
    public static final String NEW_ADMIN_LASTNAME ="LASTNAME1";
    public static final String NEW_ADMIN_USERNAME = "USERNAME1";
    public static final String NEW_ADMIN_PASSWORD = "PASSWORD1";
    public static final Date NEW_ADMIN_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);
    public static final Long NEW_ADMIN_SALARY = 15000L;
    public static final Boolean NEW_ADMIN_IS_DELETED = false;
}
