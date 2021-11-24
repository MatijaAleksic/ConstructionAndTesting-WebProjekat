package kts.restaurant_application.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "_staff")
@PrimaryKeyJoinColumn(name = "user")
public abstract class Staff extends User {

	@OneToMany(mappedBy = "staff")
	@JsonIgnore
	private Set<OrderedItem> processed = new HashSet<>();

	public Set<OrderedItem> getProcessed() {
		return processed;
	}

	public Staff() {
	}

	public Staff(Set<OrderedItem> processed) {
		this.processed = processed;
	}

	public Staff linkProcessed(OrderedItem _processed) {
		if (_processed != null) {
			_processed.unlinkStaff();
			_processed.setStaff(this);
			getProcessed().add(_processed);
		}
		return this;
	}

	public Staff unlinkProcessed(OrderedItem _processed) {
		if (_processed != null) {
			_processed.setStaff(null);
			getProcessed().remove(_processed);
		}
		return this;
	}

	public Staff unlinkProcessed(OrderedItem _processed, Iterator<OrderedItem> it) {
		if (_processed != null) {
			_processed.setStaff(null);
			it.remove();
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Staff && (getId().equals(((Staff) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 307;
	}
}