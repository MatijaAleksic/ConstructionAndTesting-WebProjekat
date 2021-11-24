package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
