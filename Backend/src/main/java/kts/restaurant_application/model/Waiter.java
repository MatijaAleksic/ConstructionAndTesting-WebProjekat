package kts.restaurant_application.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "_waiters")
@PrimaryKeyJoinColumn(name = "user")

public class Waiter extends User {
	@OneToMany(mappedBy = "waiter")
	@JsonIgnore
	private Set<Order> orders = new HashSet<>();

	public Waiter(String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary,
				  boolean deleted,Set<Order> orders) {
		this.orders = orders;
	}

	public Waiter() {
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public Waiter linkOrders(Order _orders) {
		if (_orders != null) {
			_orders.unlinkWaiter();
			_orders.setWaiter(this);
			getOrders().add(_orders);
		}
		return this;
	}

	public Waiter unlinkOrders(Order _orders) {
		if (_orders != null) {
			_orders.setWaiter(null);
			getOrders().remove(_orders);
		}
		return this;
	}

	public Waiter unlinkOrders(Order _orders, Iterator<Order> it) {
		if (_orders != null) {
			_orders.setWaiter(null);
			it.remove();
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Waiter && (getId().equals(((Waiter) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 38;
	}

}