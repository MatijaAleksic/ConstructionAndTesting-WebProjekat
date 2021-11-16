package kts.restaurant_application.repository;

import kts.restaurant_application.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findByUsername(String username);

}
