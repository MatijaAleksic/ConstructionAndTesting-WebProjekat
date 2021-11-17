
package kts.restaurant_application.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "_managers")
@PrimaryKeyJoinColumn(name = "user")

public class Manager extends User {

	public Manager(String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary,
				   boolean deleted){
	}

	public Manager() {
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Manager && (getId().equals(((Manager) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 18;
	}


}