package kts.restaurant_application.constants;

import kts.restaurant_application.model.State;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

public class UserConstants {


    public static final int FIND_ALL_NUMBER_OF_USERS= 13;

    public static final Long DB_USER_ID= 1L;
    public static final Long DB_USER_ID_DELETE= 2L;

    public static final String DB_USER_FIRSTNAME ="Marko";
    public static final String DB_USER_LASTNAME ="Peric";
    public static final String DB_USER_USERNAME = "peraperic@maildrop.cc";
    public static final String DB_USER_PASSWORD = "peraperic";
    public static final Date DB_USER_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);
    public static final Long DB_USER_SALARY = 20000L;
    public static final Boolean DB_USER_IS_DELETED = false;

    public static final int FIND_ALL_NUMBER_OF_ITEMS = 1;


    public static final String NEW_USER_FIRSTNAME ="asdf";
    public static final String NEW_USER_LASTNAME ="asdf";
    public static final String NEW_USER_USERNAME = "asdf";
    public static final String NEW_USER_PASSWORD = "asdf";
    public static final Date NEW_USER_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);
    public static final Long NEW_USER_SALARY = 20000L;
    public static final Boolean NEW_USER_IS_DELETED = false;

    }
