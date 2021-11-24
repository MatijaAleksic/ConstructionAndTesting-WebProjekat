package kts.restaurant_application.helper;


import kts.restaurant_application.dto.FoodDTO;
import kts.restaurant_application.model.Food;


public class FoodMapper implements MapperInterface<Food, FoodDTO>{

    @Override
    public Food toEntity(FoodDTO dto) {
        return new Food(dto.getId(), dto.getPrice(),dto.getName(), dto.getPriority(), dto.getSubcategory(), dto.getDescription(), dto.getDeleted());
    }

    @Override
    public FoodDTO toDto(Food entity) {
        return new FoodDTO(entity.getId(), entity.getPrice(), entity.getName(), entity.getPriority(), entity.getSubcategory(), entity.getDescription(), entity.getIsDeleted());
    }
}
