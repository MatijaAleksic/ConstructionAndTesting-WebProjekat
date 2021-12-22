package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

public class CookConstants {

    public static final int FIND_ALL_NUMBER_OF_COOKS= 4;

    public static final Long DB_COOK_ID= 6L;
    public static final Long DB_WRONG_COOK_ID= 100L;

    public static final String DB_COOK_FIRSTNAME ="Pera";
    public static final String DB_COOK_LASTNAME ="Peric";
    public static final String DB_COOK_USERNAME = "luka@maildrop.cc";
    public static final String DB_COOK_PASSWORD = "luka";
    public static final Date DB_COOK_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 12);
    public static final Long DB_COOK_SALARY = 20000L;
    public static final Boolean DB_COOK_IS_DELETED = false;



    public static final String NEW_COOK_FIRSTNAME ="FIRSTNAME1";
    public static final String NEW_COOK_LASTNAME ="LASTNAME1";
    public static final String NEW_COOK_USERNAME = "USERNAME1";
    public static final String NEW_COOK_PASSWORD = "PASSWORD1";
    public static final Date NEW_COOK_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);
    public static final Long NEW_COOK_SALARY = 15000L;
    public static final Boolean NEW_COOK_IS_DELETED = false;
}
