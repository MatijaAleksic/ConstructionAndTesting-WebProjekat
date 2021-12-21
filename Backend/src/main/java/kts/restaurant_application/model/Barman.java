package kts.restaurant_application.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "_barmen")
@PrimaryKeyJoinColumn(name = "staff")

public class Barman extends Staff {

	public Barman() {
	}

	public Barman(String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary,
				  boolean deleted, Set<OrderedItem> processed) {
		super(firstName, lastName, username, password, dateOfBirth, salary, deleted, processed);
	}

	public Barman(String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary,
				  boolean deleted) {
		super(firstName, lastName, username, password, dateOfBirth, salary, deleted);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Barman && (getId().equals(((Barman) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 451;
	}

}