package kts.restaurant_application.service;

import kts.restaurant_application.model.Food;
import kts.restaurant_application.model.Manager;
import kts.restaurant_application.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements ServiceInterface<Food>{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findOne(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public Food create(Food entity) throws Exception {

        if(foodRepository.findByName(entity.getName()) != null){
            throw new Exception("Food with given id already exists");
        }
        return foodRepository.save(entity);
    }

    @Override
    public Food update(Food entity, Long id) throws Exception {
        Food existingFood =  foodRepository.findById(id).orElse(null);
        if(existingFood == null){
            throw new Exception("Admin with given id doesn't exist");
        }
        existingFood.setPrice(entity.getPrice());
        existingFood.setPriority(entity.getPriority());
        existingFood.setName(entity.getName());
        existingFood.setSubcategory(entity.getSubcategory());
        existingFood.setDescription(entity.getDescription());
        existingFood.setIsDeleted(entity.getIsDeleted());

        return foodRepository.save(existingFood);
    }

    @Override
    public void delete(Long id) throws Exception {
        Food existingFood = foodRepository.findById(id).orElse(null);
        if(existingFood == null){
            throw new Exception("Admin with given id doesn't exist");
        }
        existingFood.setIsDeleted(true);
        foodRepository.save(existingFood);
    }
}
