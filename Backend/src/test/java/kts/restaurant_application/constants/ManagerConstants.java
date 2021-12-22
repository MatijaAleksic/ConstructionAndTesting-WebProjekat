package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

public class ManagerConstants {

    public static final int FIND_ALL_NUMBER_OF_MANAGERS= 2;

    public static final Long DB_MANAGER_ID= 11L;
    public static final Long DB_WRONG_MANAGER_ID= 100L;

    public static final String DB_MANAGER_FIRSTNAME ="Pera";
    public static final String DB_MANAGER_LASTNAME ="Peric";
    public static final String DB_MANAGER_USERNAME = "slavko@maildrop.cc";
    public static final String DB_MANAGER_PASSWORD = "slavko";
    public static final Date DB_MANAGER_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 12);
    public static final Long DB_MANAGER_SALARY = 20000L;
    public static final Boolean DB_MANAGER_IS_DELETED = false;



    public static final String NEW_MANAGER_FIRSTNAME ="FIRSTNAME1";
    public static final String NEW_MANAGER_LASTNAME ="LASTNAME1";
    public static final String NEW_MANAGER_USERNAME = "USERNAME1";
    public static final String NEW_MANAGER_PASSWORD = "PASSWORD1";
    public static final Date NEW_MANAGER_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);

    public static final Long NEW_MANAGER_SALARY = 15000L;
    public static final Boolean NEW_MANAGER_IS_DELETED = false;
}
