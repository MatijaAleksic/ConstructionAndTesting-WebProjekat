package kts.restaurant_application.repository;

import kts.restaurant_application.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByName(String name);
}
