package kts.restaurant_application.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "_admins")
@PrimaryKeyJoinColumn(name = "user")

public class Admin extends User {
	public Admin(String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary,
            boolean deleted) {
		super(firstName, lastName, username, password, dateOfBirth, salary, deleted);
    }

	public Admin() {
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Admin && (getId().equals(((Admin) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 178;
	}

}