/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.repositories;

import kts.restaurant_application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kts.restaurant_application.model.Cook;

import java.util.Optional;

@Repository
public interface CookRepository extends CrudRepository<Cook, Long> {
    Optional<Cook> findByUsername(String username);
}