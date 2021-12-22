package kts.restaurant_application.services;

import javax.transaction.Transactional;

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
        return repository.findAll();
    }

    public Item findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Item by " + id));
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
        existingItem.setIsDeleted(entity.getIsDeleted());

        return save(existingItem);
    }

    public Item delete(Item entity) {
        Item existingItem = findOne(entity.getId());
        existingItem.setIsDeleted(true);
        return save(existingItem);
    }

    public Item delete(Long id) {
        return delete(findOne(id));
    }
}