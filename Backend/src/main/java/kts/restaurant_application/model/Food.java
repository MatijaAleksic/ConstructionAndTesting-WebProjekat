package kts.restaurant_application.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
// ----------- << imports@AAAAAAF9CYNzuFNUgjE= >>
// ----------- >>
import javax.persistence.Table;

@Entity
@Table(name = "_foods")
@PrimaryKeyJoinColumn(name = "item")
public class Food extends Item {

	public Food(Long id, Long version, Double price, Byte priority,String subcategory, String description,
				boolean isDeleted, String name){
		super(id,version,price,priority,subcategory,description,isDeleted,name);
	}

	public Food(Double price, Byte priority,String subcategory, String description,
				boolean isDeleted, String name){
		super(price,priority,subcategory,description,isDeleted,name);
	}

	public Food() {
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Food && (getId().equals(((Food) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 524;
	}

}