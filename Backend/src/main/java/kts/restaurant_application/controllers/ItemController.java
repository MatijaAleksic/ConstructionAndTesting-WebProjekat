/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/


package kts.restaurant_application.controllers;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.services.ItemService;

@Transactional
@RestController
@RequestMapping("/items")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Item> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Item findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public Item create(@RequestBody @Valid Item entity) {
        return service.save(entity);
    }

    @PostMapping("/update")
    public Item update(@RequestBody Item entity){
        return service.update(entity);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}