package kts.restaurant_application.DTO;

import java.util.ArrayList;

import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.TableStatus;


public class TableDTO {
    public Long id;
    public Integer floor;
    public TableStatus state;
    public Position position;
    public ArrayList<Long> orders;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public TableStatus getState() {
        return state;
    }
    public void setState(TableStatus state) {
        this.state = state;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public ArrayList<Long> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Long> orders) {
        this.orders = orders;
    }
    public TableDTO(Long id, Integer floor, TableStatus state, Position position) {
        this.id = id;
        this.floor = floor;
        this.state = state;
        this.position = position;
    }

    public TableDTO(RestourantTables table){
        this.id = table.getId();
        this.floor = table.getFloor();
        this.position = new Position(table.getPositionX(), table.getPositionY());
        this.state = table.getState();
        this.orders = new ArrayList<>();
        for (Order o : table.getOrders()){
            this.orders.add(o.getId());
        }
    }

    public TableDTO(){}
    public TableDTO(Long id, Integer floor, TableStatus state, Position position,
            ArrayList<Long> orders) {
        this.id = id;
        this.floor = floor;
        this.state = state;
        this.position = position;
        this.orders = orders;
    }
    
}
