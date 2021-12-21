package kts.restaurant_application.constants;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

public class ItemConstants {

    public static final int FIND_ALL_NUMBER_OF_ITEMS= 6;

    public static final Long DB_ITEM_ID= 1L;
    public static final Long DB_WRONG_ITEM_ID= 100L;

    public static final String DB_ITEM_DESCRIPTION ="Deskripcija1";
    public static final String DB_ITEM_NAME ="Pice1";
    public static final String DB_ITEM_STATUS = "active";
    public static final Double DB_ITEM_PRICE = 100.0;
    public static final Byte DB_ITEM_PRIPRITY = 1;
    public static final String DB_ITEM_SUBCATEGORY = "subcategory1";
    public static final Boolean DB_ITEM_IS_DELETED = false;


    public static final String DB_NEW_ITEM_DESCRIPTION ="NEW_DESCRIPTION";
    public static final String DB_NEW_ITEM_NAME ="NEW_NAME";
    public static final String DB_NEW_ITEM_STATUS = "active";
    public static final Double DB_NEW_ITEM_PRICE = 999.0;
    public static final Byte DB_NEW_ITEM_PRIPRITY = 2;
    public static final String DB_NEW_ITEM_SUBCATEGORY = "NEW_SUBCATEGORY";
    public static final Boolean DB_NEW_ITEM_IS_DELETED = false;


}
