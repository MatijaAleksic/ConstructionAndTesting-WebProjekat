package kts.restaurant_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kts.restaurant_application.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);
}
