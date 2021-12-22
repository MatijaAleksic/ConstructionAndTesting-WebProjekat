package kts.restaurant_application.constants;

import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.Waiter;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

public class OrderConstants {

    public static final int FIND_ALL_NUMBER_OF_ORDERS= 2;

    public static final Long DB_ORDER_ID= 1L;
    public static final Long DB_ORDER_ID2= 2L;
    public static final Long DB_WRONG_ORDER_ID= 100L;
    public static final Long DB_NEW_ORDER_ID= 3L;


    public static final Double DB_ORDER_PRICE =100.0;
    public static final String DB_ORDER_NOTE = "";
    public static final Date DB_ORDER_DATETIME = new Date(2012, Calendar.DECEMBER, 12);

    public static final Long DB_ORDER_RESTOURANT_TABLE_ID= 1L;
    public static final Long DB_ORDER_WAITER_ID= 12L;

    public static final Double NEW_ORDER_PRICE =999.0;
    public static final String NEW_ORDER_DATETIME = "active";
}
