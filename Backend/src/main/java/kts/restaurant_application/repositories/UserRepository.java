package kts.restaurant_application.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kts.restaurant_application.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}