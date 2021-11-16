package kts.restaurant_application.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class FoodDTO {

    @NotBlank(message = "ID cannot be empty.")
    private Long id;
    @NotBlank(message = "Price cannot be empty.")
    private Double price;
    private String name;
    private Byte priority;
    private String subcategory;
    private String description;
    private boolean isDeleted;

    public FoodDTO(@NotBlank(message = "ID cannot be empty.") Long id, @NotBlank(message = "Price cannot be empty.") Double price,String name, Byte priority, String subcategory, String description, boolean isDeleted) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.priority = priority;
        this.subcategory = subcategory;
        this.description = description;
        this.isDeleted = isDeleted;
    }



    public FoodDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
