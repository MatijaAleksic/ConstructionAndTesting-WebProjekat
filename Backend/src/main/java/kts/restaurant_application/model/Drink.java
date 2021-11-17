/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package kts.restaurant_application.model;


import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "_drinks")

public class Drink extends Item {

	public Drink() {
	}

	public Drink(Long id, Long version, Double price, Byte priority, String subcategory, String description,
				 boolean isDeleted, String name) {
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Drink && (getId().equals(((Drink) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 211;
	}

}