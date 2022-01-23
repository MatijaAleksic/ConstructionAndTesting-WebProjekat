package kts.restaurant_application.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "_drinks")
@PrimaryKeyJoinColumn(name = "item")

public class Drink extends Item {

	public Drink() {
	}

	public Drink(Long id, Long version, Double price, Byte priority, String subcategory, String description,
				 boolean isDeleted, String name) {

		super(id,version,price,priority,subcategory,description,isDeleted,name);
	}

	public Drink(Double price, Byte priority, String subcategory, String description,
				 boolean isDeleted, String name) {

		super(price,priority,subcategory,description,isDeleted,name);
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