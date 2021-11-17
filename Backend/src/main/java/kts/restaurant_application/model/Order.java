package kts.restaurant_application.model;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "_orders")
@ApiModel(description = "")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Version
	private Long version;

	@NotNull
	@Column(nullable = false)

	private Double price;

	@NotNull
	@Column(nullable = false)
	private String note;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "waiter_id")
	private Waiter waiter;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "table_id")
	private RestourantTables table;

	@OneToMany
	@JoinColumn(name = "_id")
	private Set<OrderedItem> food = new HashSet<>();

	public Order(Long id, Long version, @NotNull Double price, @NotNull String note, @NotNull Waiter waiter, @NotNull RestourantTables table, Set<OrderedItem> food) {
		this.id = id;
		this.version = version;
		this.price = price;
		this.note = note;
		this.waiter = waiter;
		this.table = table;
		this.food = food;
	}

	public Order() {
	}

	public Long getId(){
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public String getNote() {
		return note;
	}

	public Waiter getWaiter() {
		return waiter;
	}

	public RestourantTables getTable() {
		return table;
	}

	public Set<OrderedItem> getFood() {
		return food;
	}

	public Order setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Order setNote(String note) {
		this.note = note;
		return this;
	}

	public Order setWaiter(Waiter waiter) {
		this.waiter = waiter;
		return this;
	}

	public Order setTable(RestourantTables table) {
		this.table = table;
		return this;
	}

	public Order linkWaiter(Waiter _waiter) {
		if (_waiter != null) {
			_waiter.getOrders().add(this);
		}

		unlinkWaiter();
		setWaiter(_waiter);
		return this;
	}

	public Order linkTable(RestourantTables _table) {
		if (_table != null) {
			_table.getOrders().add(this);
		}

		unlinkTable();
		setTable(_table);
		return this;
	}

	public Order linkFood(OrderedItem _food) {
		if (_food != null) {
			getFood().add(_food);
		}
		return this;
	}

	public Order unlinkWaiter() {
		if (getWaiter() != null) {
			getWaiter().getOrders().remove(this);
			setWaiter(null);
		}
		return this;
	}

	public Order unlinkTable() {
		if (getTable() != null) {
			getTable().getOrders().remove(this);
			setTable(null);
		}
		return this;
	}

	public Order unlinkFood(OrderedItem _food) {
		if (_food != null) {
			getFood().remove(_food);
		}
		return this;
	}

	public Order unlinkFood(Iterator<OrderedItem> it) {
		it.remove();
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Order && (getId().equals(((Order) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 152;
	}

}