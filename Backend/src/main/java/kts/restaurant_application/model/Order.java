package kts.restaurant_application.model;


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "_orders")
@ApiModel(description = "")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@NotNull
	@Column(nullable = false)
	private Double price;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "waiter_id")
	private Waiter waiter;

	@NotNull
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "restourantTable_id")
	private RestourantTables restourantTable;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateTime;

	@OneToMany
	@JoinColumn(name = "_id")
	private Set<OrderedItem> food = new HashSet<>();

	public Order(Long id, Long version, @NotNull Double price, @NotNull String note, @NotNull Waiter waiter, @NotNull RestourantTables restourantTable, Set<OrderedItem> food, @NotNull Date dateTime) {
		this.id = id;
		this.version = version;
		this.price = price;
		this.waiter = waiter;
		this.restourantTable = restourantTable;
		this.food = food;
		this.dateTime = dateTime;
	}

	public Order(@NotNull Double price, @NotNull String note, @NotNull Waiter waiter, @NotNull RestourantTables table, @NotNull Date dateTime) {
		this.price = price;
		this.waiter = waiter;
		this.restourantTable = table;
		this.dateTime = dateTime;
	}

	public Order(@NotNull Double price, @NotNull Date dateTime) {
		this.price = price;
		this.dateTime = dateTime;
	}


	public Order() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getId(){
		return id;
	}

	public Double getPrice() {
		return price;
	}


	public Waiter getWaiter() {
		return waiter;
	}



	public Set<OrderedItem> getFood() {
		return food;
	}

	public Order setPrice(Double price) {
		this.price = price;
		return this;
	}


	public Order setWaiter(Waiter waiter) {
		this.waiter = waiter;
		return this;
	}


	public RestourantTables getRestouranttable() {
		return restourantTable;
	}

	public void setRestouranttable(RestourantTables restourantTable) {
		this.restourantTable = restourantTable;
	}


	public RestourantTables getRestourantTable() {
		return restourantTable;
	}

	public void setRestourantTable(RestourantTables restourantTable) {
		this.restourantTable = restourantTable;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
		setRestourantTable(_table);
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
		if (getRestourantTable() != null) {
			getRestourantTable().getOrders().remove(this);
			setRestourantTable(null);
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

	public void setFood(Set<OrderedItem> food) {
		this.food = food;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	


}