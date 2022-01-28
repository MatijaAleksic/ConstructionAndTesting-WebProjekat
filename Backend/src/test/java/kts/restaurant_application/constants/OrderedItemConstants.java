package kts.restaurant_application.constants;

import java.util.Calendar;
import java.util.Date;

import kts.restaurant_application.model.State;

public class OrderedItemConstants {

    public static final State NEW_ORDERED_ITEM_STATE= State.ordered;
    public static final Integer NEW_ORDERED_ITEM_NUMBER= 5;
    public static final Date NEW_ORDERED_ITEM_DATETIME= new Date(2021, Calendar.DECEMBER, 13);
    public static final String NEW_ORDERED_ITEM_NOTE= "Novi note";
    public static final Double NEW_ORDERED_ITEM_PRICE= 100.0;
    public static final Long NEW_ORDERED_ITEM_ID = 3L;


    public static final Date ORDERED_ITEM_DATETIME_FROM= new Date(2012, Calendar.DECEMBER, 12);
    public static final Date ORDERED_ITEM_DATETIME_TO= new Date(2012, Calendar.DECEMBER, 12);


//    public static final String NEW_CATEGORY_TYPE2 = "Spomenik";
//    public static final long CATEGORY_TYPE_SIZE = 2;
//
//    public static final String DB_CATEGORY_TYPE = "Muzej";
//    public static final Long DB_CATEGORY_TYPE_ID = 1L;
//    public static final long DB_CATEGORY_SIZE = 1;



    public static final int FIND_ALL_NUMBER_OF_ORDERED_ITEMS= 2;

    public static final Long DB_ORDERED_ITEM_ID= 1L;
    public static final Long DB_WRONG_ORDERED_ITEM_ID= 100L;

    public static final State DB_ORDERED_ITEM_STATE= State.ordered;
    public static final Integer DB_ORDERED_ITEM_NUMBER= 2;
    public static final Date DB_ORDERED_ITEM_DATETIME= new Date(2021, Calendar.DECEMBER, 12);
    public static final String DB_ORDERED_ITEM_NOTE= "alergija na kikiriki";
    public static final Double DB_ORDERED_ITEM_PRICE= 50.0;

    public static final Long DB_O_ITEM_ID= 1L;
    public static final Long DB_O_STAFF_ID= 5L;
    public static final Long DB_ID_ID= 1L;

    public static final State DB_ORDERED_ITEM_STATE_UNIT1= State.ordered;
    public static final Integer DB_ORDERED_ITEM_NUMBER_UNIT1= 2;
    public static final Date DB_ORDERED_ITEM_DATETIME_UNIT1= new Date(2021, Calendar.DECEMBER, 12);
    public static final String DB_ORDERED_ITEM_NOTE_UNIT1= "alergija na kikiriki";
    public static final Double DB_ORDERED_ITEM_PRICE_UNIT1= 50.0;

    public static final State DB_ORDERED_ITEM_STATE_UNIT2= State.ordered;
    public static final Integer DB_ORDERED_ITEM_NUMBER_UNIT2= 2;
    public static final Date DB_ORDERED_ITEM_DATETIME_UNIT2= new Date(2021, Calendar.DECEMBER, 12);
    public static final String DB_ORDERED_ITEM_NOTE_UNIT2= "alergija na kikiriki";
    public static final Double DB_ORDERED_ITEM_PRICE_UNIT2= 50.0;

    public static final int DB_SAVED_ORDERED_ITEM_ID_UNIT= 3;
    public static final Boolean DB_ORDERED_ITEM_IS_DELETED_UNIT = true;


}
