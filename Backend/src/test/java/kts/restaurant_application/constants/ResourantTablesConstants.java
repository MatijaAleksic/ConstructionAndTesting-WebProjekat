package kts.restaurant_application.constants;

import kts.restaurant_application.model.TableStatus;

public class ResourantTablesConstants {

    public static final int FIND_ALL_NUMBER_OF_RESTOURANT_TABLES= 2;

    public static final Long DB_RESTOURANT_TABLE_ID= 1L;
    public static final Long DB_WRONG_RESTOURANT_TABLE_ID= 100L;


    public static final Long DB_RESTOURANT_TABLE_NUMBER =1L;
    public static final Integer DB_RESTOURANT_TABLE_FLOOR =1;
    public static final Double DB_RESTOURANT_TABLE_POSITION_X = 1.0;
    public static final Double DB_RESTOURANT_TABLE_POSITION_Y = 2.0;
    public static final TableStatus DB_RESTOURANT_TABLE_STATE = TableStatus.free;
    public static final Boolean DB_RESTOURANT_TABLE_IS_DELETED = false;

    public static final Long DB_NEW_RESTOURANT_TABLE_NUMBER =99L;
    public static final Integer DB_NEW_RESTOURANT_TABLE_FLOOR =999;
    public static final Double DB_NEW_RESTOURANT_TABLE_POSITION_X = 999.0;
    public static final Double DB_NEW_RESTOURANT_TABLE_POSITION_Y = 999.0;
    public static final TableStatus DB_NEW_RESTOURANT_TABLE_STATE = TableStatus.free;
    public static final Boolean DB_NEW_RESTOURANT_TABLE_IS_DELETED = false;


}
