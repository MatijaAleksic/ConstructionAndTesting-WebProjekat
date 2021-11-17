package kts.restaurant_application.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "_tables")
@ApiModel(description = "")
public class RestourantTables {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;

	@NotNull
	@Column(nullable = false)
	private Long tableNumber;

	@NotNull
	@Column(nullable = false)
	private Integer floor;

	@NotNull
	@Column(nullable = false)
	private Double positionX;

	@NotNull
	@Column(nullable = false)
	private Double positionY;

	@NotNull
	@Column(nullable = false)
	private State state;

	@NotNull
	@Column(nullable = false)
	private Boolean isDeleted;

	@OneToMany(mappedBy = "table")
	private Set<Order> orders = new HashSet<>();

	public Long getId(){
		return id;
	}

	public Long getTableNumber() {
		return tableNumber;
	}

	public Integer getFloor() {
		return floor;
	}

	public Double getPositionX() {
		return positionX;
	}

	public Double getPositionY() {
		return positionY;
	}

	public State getState() {
		return state;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public RestourantTables() {
	}

	public RestourantTables(Long id, Long version, @NotNull Long tableNumber, @NotNull Integer floor, @NotNull Double positionX, @NotNull Double positionY, @NotNull State state, @NotNull Boolean isDeleted, Set<Order> orders) {
		this.id = id;
		this.version = version;
		this.tableNumber = tableNumber;
		this.floor = floor;
		this.positionX = positionX;
		this.positionY = positionY;
		this.state = state;
		this.isDeleted = isDeleted;
		this.orders = orders;
	}

	public RestourantTables setTableNumber(Long tableNumber) {
		this.tableNumber = tableNumber;
		return this;
	}

	public RestourantTables setFloor(Integer floor) {
		this.floor = floor;
		return this;
	}

	public RestourantTables setPositionX(Double positionX) {
		this.positionX = positionX;
		return this;
	}

	public RestourantTables setPositionY(Double positionY) {
		this.positionY = positionY;
		return this;
	}

	public RestourantTables setState(State state) {
		this.state = state;
		return this;
	}

	public RestourantTables setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public RestourantTables linkOrders(Order _orders) {
		if (_orders != null) {
			_orders.unlinkTable();
			_orders.setTable(this);
			getOrders().add(_orders);
		}
		return this;
	}

	public RestourantTables unlinkOrders(Order _orders) {
		if (_orders != null) {
			_orders.setTable(null);
			getOrders().remove(_orders);
		}
		return this;
	}

	public RestourantTables unlinkOrders(Order _orders, Iterator<Order> it) {
		if (_orders != null) {
			_orders.setTable(null);
			it.remove();
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof RestourantTables && (getId().equals(((RestourantTables) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 115;
	}

}