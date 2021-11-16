package kts.restaurant_application.controller;

import kts.restaurant_application.dto.FoodDTO;
import kts.restaurant_application.helper.FoodMapper;
import kts.restaurant_application.model.Food;
import kts.restaurant_application.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value =  "/api/food", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController {

    @Autowired
    private FoodService foodService;

    private final FoodMapper foodMapper;

    public FoodController() {
        foodMapper = new FoodMapper();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FoodDTO>> getAllFood() {
        List<Food> foods = foodService.findAll();

        return new ResponseEntity<>(toUserDTOList(foods), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<FoodDTO> getFood(@PathVariable Long id){
        Food food = foodService.findOne(id);
        if(food == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(foodMapper.toDto(food), HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodDTO> createFood(@RequestBody FoodDTO foodDTO){

        Food food;

        System.out.println(foodDTO.getDeleted() + " " + foodDTO.getPriority() + " " + foodDTO.getPrice());
        try {
            food = foodService.create(foodMapper.toEntity(foodDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(foodMapper.toDto(food), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodDTO> updateFood(@RequestBody FoodDTO foodDTO, @PathVariable Long id){
        Food food;
        try {
            food = foodService.update(foodMapper.toEntity(foodDTO), id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(foodMapper.toDto(food), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFood(@PathVariable Long id){
        try {
            foodService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private List<FoodDTO> toUserDTOList(List<Food> foods){
        List<FoodDTO> foodDTOS = new ArrayList<>();
        for (Food food: foods) {
            foodDTOS.add(foodMapper.toDto(food));
        }
        return foodDTOS;
    }

}
