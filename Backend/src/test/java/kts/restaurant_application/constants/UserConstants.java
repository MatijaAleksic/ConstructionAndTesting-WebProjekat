package kts.restaurant_application.constants;

import kts.restaurant_application.model.State;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

public class UserConstants {


    public static final int FIND_ALL_NUMBER_OF_USERS= 13;

    public static final Long DB_USER_ID= 1L;
    public static final Long DB_WRONG_USER_ID= 100L;
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

    public static final String DB_USER_FIRSTNAME_UNIT1 ="FIRSTNAME1";
    public static final String DB_USER_LASTNAME_UNIT1 ="LASTNAME1";
    public static final String DB_USER_USERNAME_UNIT1 = "USERNAME1";
    public static final String DB_USER_PASSWORD_UNIT1 = "PASSWORD1";
    public static final Date DB_USER_DATE_OF_BIRTH_UNIT1 = new Date(2015, Calendar.DECEMBER, 11);
    public static final Long DB_USER_SALARY_UNIT1 = 999L;
    public static final Boolean DB_USER_IS_DELETED_UNIT1 = false;

    public static final String DB_USER_FIRSTNAME_UNIT2 ="FIRSTNAME2";
    public static final String DB_USER_LASTNAME_UNIT2 ="LASTNAME2";
    public static final String DB_USER_USERNAME_UNIT2 = "USERNAME2";
    public static final String DB_USER_PASSWORD_UNIT2 = "PASSWORD2";
    public static final Date DB_USER_DATE_OF_BIRTH_UNIT2 = new Date(2017, Calendar.DECEMBER, 11);
    public static final Long DB_USER_SALARY_UNIT2 = 555L;
    public static final Boolean DB_USER_IS_DELETED_UNIT2 = false;

    public static final int FIND_ALL_NUMBER_OF_USERS_UNIT = 3;
    public static final Long DB_SAVED_USER_ID_UNIT= 2L;
    public static final Boolean DB_USER_IS_DELETED_UNIT = true;

    }
