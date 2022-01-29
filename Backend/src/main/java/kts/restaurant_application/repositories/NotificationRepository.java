package kts.restaurant_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kts.restaurant_application.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
