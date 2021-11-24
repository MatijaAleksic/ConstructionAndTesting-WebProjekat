package kts.restaurant_application.controllers;

import kts.restaurant_application.model.Notification;
import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.services.NotificationService;
import kts.restaurant_application.services.OrderService;
import kts.restaurant_application.services.TableService;
import kts.restaurant_application.services.WaiterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Iterable<Notification> findAll(@RequestBody String type) {
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


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


