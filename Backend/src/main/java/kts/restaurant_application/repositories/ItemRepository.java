/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kts.restaurant_application.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Collection<Item> findAllBySubcategory(String subcategory);

}