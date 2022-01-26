/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.Barman;
import kts.restaurant_application.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.repositories.WaiterRepository;

import java.util.ArrayList;

@Service
public class WaiterService {
    private static final Logger logger = LoggerFactory.getLogger(WaiterService.class);

    private final WaiterRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public WaiterService(WaiterRepository repository) {
        this.repository = repository;
    }

    public Iterable<Waiter> findAll() {
        Iterable<Waiter> all = repository.findAll();
        ArrayList<Waiter> notDeleted = new ArrayList<>();

        for(Waiter b : all){
            if(!b.getIsDeleted()){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Waiter findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Waiter by " + id));
    }

    public Waiter save(Waiter entity) {
        return repository.save(entity);
    }

    public Waiter delete(Waiter entity) {
        Waiter existingWaiter = findOne(entity.getId());
        existingWaiter.setIsDeleted(true);
        return save(existingWaiter);
    }

    public Waiter update(Waiter entity){
        Waiter existingWaiter = findOne(entity.getId());

        existingWaiter.setFirstName(entity.getFirstName());
        existingWaiter.setLastName(entity.getLastName());
        existingWaiter.setPassword(passwordEncoder.encode(entity.getPassword()));
        existingWaiter.setDateOfBirth(entity.getDateOfBirth());
        existingWaiter.setSalary(entity.getSalary());
        existingWaiter.setIsDeleted(entity.getIsDeleted());

        return save(existingWaiter);
    }

    public Waiter delete(Long id) {
        return delete(findOne(id));
    }
}