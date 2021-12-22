package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

public class BarmanConstants {

    public static final int FIND_ALL_NUMBER_OF_BARMANS= 2;

    public static final Long DB_BARMAN_ID= 5L;
    public static final Long DB_WRONG_BARMAN_ID= 100L;


    public static final String DB_BARMAN_FIRSTNAME ="Pera";
    public static final String DB_BARMAN_LASTNAME ="Peric";
    public static final String DB_BARMAN_USERNAME = "pavlepavlovic@maildrop.cc";
    public static final String DB_BARMAN_PASSWORD = "peraperic";
    public static final Date DB_BARMAN_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 12);
    public static final Long DB_BARMAN_SALARY = 20000L;
    public static final Boolean DB_BARMAN_IS_DELETED = false;


    public static final String NEW_BARMAN_FIRSTNAME ="FIRSTNAME1";
    public static final String NEW_BARMAN_LASTNAME ="LASTNAME1";
    public static final String NEW_BARMAN_USERNAME = "USERNAME1";
    public static final String NEW_BARMAN_PASSWORD = "PASSWORD1";
    public static final Date NEW_BARMAN_DATE_OF_BIRTH = new Date(2012, Calendar.DECEMBER, 11);
    public static final Long NEW_BARMAN_SALARY = 15000L;
    public static final Boolean NEW_BARMAN_IS_DELETED = false;
}
