package kts.restaurant_application.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;
import java.time.*;

@Entity
@Table(name="staff_table")
public abstract class Staff extends User {


	//private Set<OrderedItem> processed = new HashSet<>();

	public Staff(Long id, String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
		super(id, firstName, lastName, username, password, dateOfBirth, salary, isDeleted);
	}

	public Staff() {

	}

//	public Set<OrderedItem> getProcessed() {
//		return processed;
//	}

}