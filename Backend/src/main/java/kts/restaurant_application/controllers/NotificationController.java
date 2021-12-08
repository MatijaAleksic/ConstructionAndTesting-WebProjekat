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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kts.restaurant_application.model.Notification;
import kts.restaurant_application.services.NotificationService;

@Transactional
@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final NotificationService service;


    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.service = notificationService;

    }

    @GetMapping()
    public Iterable<Notification> findAll(@RequestParam String type) {
        return service.findAll(type);
    }

    @GetMapping("/{id}")
    public Notification findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public Notification create(@RequestBody @Valid Notification entity) {
        return service.save(entity);
    }


    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


