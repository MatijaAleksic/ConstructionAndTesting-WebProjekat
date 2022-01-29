package kts.restaurant_application.DTO;

public class OrderDTO {
    
    public Long id;

    public Double price;

	public Long waiter;

	public Long restourantTable;

    public Long[] orderedItems;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getWaiter() {
        return waiter;
    }

    public void setWaiter(Long waiter) {
        this.waiter = waiter;
    }

    public Long getRestourantTable() {
        return restourantTable;
    }

    public void setRestourantTable(Long restourantTable) {
        this.restourantTable = restourantTable;
    }

    public Long[] getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Long[] orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
