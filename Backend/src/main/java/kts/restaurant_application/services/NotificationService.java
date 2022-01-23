package kts.restaurant_application.services;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.Notification;
import kts.restaurant_application.model.UserTypes;
import kts.restaurant_application.repositories.ManagerRepository;
import kts.restaurant_application.repositories.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    private final NotificationRepository repository;

    @Autowired
    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Iterable<Notification> findAll(String type) {
        Iterable<Notification> allNotifications = repository.findAll();

        List<Notification> returnNotifications = new ArrayList<>();
        for(Notification notification : allNotifications){
            if(notification.getUserType().toString().equals(type)){
                returnNotifications.add(notification);
            }
        }
        return returnNotifications;
    }

    public Notification findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Notification by " + id));
    }

    public Notification save(Notification entity) {
        return repository.save(entity);
    }

    public boolean delete(Notification entity) {
        if(findOne(entity.getId()) != null){
            repository.delete(entity);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        return delete(findOne(id));
    }
}
