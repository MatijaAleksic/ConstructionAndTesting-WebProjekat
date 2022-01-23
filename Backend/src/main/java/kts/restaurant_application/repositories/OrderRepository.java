/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kts.restaurant_application.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    // @Query(value = "SELECT n FROM _orders WHERE n.date_time >= ?1 AND WHERE n.date_time <= ?2", nativeQuery = true)
    // public List<Order> findOrdersByDate(LocalDateTime dateFrom, LocalDateTime dateTo);

    Collection<Order> findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(Date dateFrom, Date dateTo);
    


}