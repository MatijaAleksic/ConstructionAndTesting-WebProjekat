/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.repositories.FoodRepository;

import java.util.ArrayList;

@Service
public class FoodService {
    private static final Logger logger = LoggerFactory.getLogger(FoodService.class);

    private final FoodRepository repository;

    @Autowired
    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public Iterable<Food> findAll() {
        Iterable<Food> all = repository.findAll();
        ArrayList<Food> notDeleted = new ArrayList<>();

        for(Food b : all){
            if(!b.getIsDeleted() && b.getItemStatus() != ItemStatus.newItem){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Iterable<Food> findAllNew() {
        Iterable<Food> all = repository.findAll();
        ArrayList<Food> notDeleted = new ArrayList<>();

        for(Food b : all){
            if(!b.getIsDeleted() && b.getItemStatus() == ItemStatus.newItem){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Food findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Food by " + id));
    }

    @Transactional
    public Food save(Food entity) {
        return repository.save(entity);
    }

    @Transactional
    public Food update(Food entity){
        Food existingFood = findOne(entity.getId());

        existingFood.setName(entity.getName());
        existingFood.setDescription(entity.getDescription());
        existingFood.setPrice(entity.getPrice());
        existingFood.setPriority(entity.getPriority());
        existingFood.setSubcategory(entity.getSubcategory());
        existingFood.setItemStatus(entity.getItemStatus());


        return save(existingFood);
    }

    public Food delete(Food entity) {
        Food existingFood = findOne(entity.getId());
        existingFood.setIsDeleted(true);
        return save(existingFood);

    }

    public Food delete(Long id) {
        return delete(findOne(id));
    }
}