/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.Barman;
import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Staff;
import kts.restaurant_application.repositories.StaffRepository;

import java.util.ArrayList;

@Service
public class StaffService {
    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    private final StaffRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    public Iterable<Staff> findAll() {
        Iterable<Staff> all = repository.findAll();
        ArrayList<Staff> notDeleted = new ArrayList<>();

        for(Staff b : all){
            if(!b.getIsDeleted()){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Staff findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Staff by " + id));
    }

    public Staff save(Staff entity) {
        return repository.save(entity);
    }

    public Staff update(Staff entity){
        Staff existingManager = findOne(entity.getId());

        existingManager.setFirstName(entity.getFirstName());
        existingManager.setLastName(entity.getLastName());
        existingManager.setPassword(entity.getPassword());
        existingManager.setDateOfBirth(entity.getDateOfBirth());
        existingManager.setSalary(entity.getSalary());

        return save(existingManager);
    }

    public Staff delete(Staff entity) {
        Staff existingStaff = findOne(entity.getId());
        existingStaff.setIsDeleted(true);
        return save(existingStaff);
    }

    public Staff delete(Long id) {
        return delete(findOne(id));
    }
}