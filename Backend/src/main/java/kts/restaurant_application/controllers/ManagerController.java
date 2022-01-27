/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.controllers;


import javax.validation.Valid;

import kts.restaurant_application.model.Authority;
import kts.restaurant_application.services.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.services.ManagerService;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/managers")
public class ManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    private final ManagerService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Manager> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Manager findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public Manager create(@RequestBody @Valid Manager entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setIsDeleted(false);

        List<Authority> auth = new ArrayList<Authority>();

        auth.add(authorityService.findByName("ROLE_USER"));
        auth.add(authorityService.findByName("ROLE_MANAGER"));

        entity.setAuthorities(auth);

        return service.save(entity);
    }

    @PostMapping("/update")
    public Manager update(@RequestBody Manager entity){
        return service.update(entity);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }
}