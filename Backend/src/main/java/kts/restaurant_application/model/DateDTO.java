package kts.restaurant_application.model;


import java.util.Date;



public class DateDTO {

    public Date dateFrom;
    public Date dateTo;
    public DateDTO(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    


    public DateDTO(){}
}
