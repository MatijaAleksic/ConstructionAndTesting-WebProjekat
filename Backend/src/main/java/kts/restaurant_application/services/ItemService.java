package kts.restaurant_application.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import javax.transaction.Transactional;

import kts.restaurant_application.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.repositories.ItemRepository;

@Service
@Transactional
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Iterable<Item> findAll() {
        Iterable<Item> all = repository.findAll();
        ArrayList<Item> notDeleted = new ArrayList<>();

        for(Item b : all){
            if(!b.getIsDeleted()){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Item findOne(Long id) {
        Optional<Item> item = repository.findById(id);
        if(item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Cannot find Item by " + id);
        }
        return item.get();
    }

    public Item save(Item entity) {
        return repository.save(entity);
    }

    public Item update(Item entity){
        Item existingItem = findOne(entity.getId());

        existingItem.setName(entity.getName());
        existingItem.setDescription(entity.getDescription());
        existingItem.setPrice(entity.getPrice());
        existingItem.setPriority(entity.getPriority());
        existingItem.setSubcategory(entity.getSubcategory());

        return save(existingItem);
    }

    public Item delete(Item entity) {
        Item existingItem = findOne(entity.getId());
        existingItem.setIsDeleted(true);
        return save(existingItem);
    }

    public Item delete(Long id) {
        Item item = findOne(id);
        return delete(item);
    }

    public String[] getSubcategories() {
        HashSet<String> hashset = new HashSet<>();
        for (Item item : this.findAll()){
            hashset.add(item.getSubcategory());
        }
        return hashset.toArray( new String[hashset.size()]);
    }

    public Collection<Item> findAllBySubcategory(String subcategory){
        System.out.println("AAAAAA");
        return this.repository.findAllBySubcategory(subcategory);
    }
}