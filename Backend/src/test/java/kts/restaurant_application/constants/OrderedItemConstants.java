package kts.restaurant_application.constants;

import kts.restaurant_application.model.State;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

public class OrderedItemConstants {

    public static final State NEW_ORDERED_ITEM_STATE= State.ordered;
    public static final Integer NEW_ORDERED_ITEM_NUMBER= 5;
    public static final Date NEW_ORDERED_ITEM_DATETIME= new Date(2021, Calendar.DECEMBER, 13);
    public static final String NEW_ORDERED_ITEM_NOTE= "Novi note";
    public static final Integer NEW_ORDERED_ITEM_PRICE= 100;


    public static final Date ORDERED_ITEM_DATETIME_FROM= new Date(2012, Calendar.DECEMBER, 12);
    public static final Date ORDERED_ITEM_DATETIME_TO= new Date(2012, Calendar.DECEMBER, 12);


//    public static final String NEW_CATEGORY_TYPE2 = "Spomenik";
//    public static final long CATEGORY_TYPE_SIZE = 2;
//
//    public static final String DB_CATEGORY_TYPE = "Muzej";
//    public static final Long DB_CATEGORY_TYPE_ID = 1L;
//    public static final long DB_CATEGORY_SIZE = 1;

}
