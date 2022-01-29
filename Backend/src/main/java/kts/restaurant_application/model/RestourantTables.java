package kts.restaurant_application.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "_tables")
@ApiModel(description = "")
public class RestourantTables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;


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
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TableStatus state;

	@NotNull
	@Column(nullable = false)
	private Boolean isDeleted;

	@JsonIgnore
	@OneToMany(mappedBy = "restourantTable")
	private Set<Order> orders = new HashSet<>();


	public Integer getFloor() {
		return floor;
	}

	public Double getPositionX() {
		return positionX;
	}

	public Double getPositionY() {
		return positionY;
	}

	public TableStatus getState() {
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

	public RestourantTables(Long id, Long version, @NotNull Integer floor, @NotNull Double positionX, @NotNull Double positionY, @NotNull TableStatus state, @NotNull Boolean isDeleted, Set<Order> orders) {
		this.id = id;
		this.version = version;
		this.floor = floor;
		this.positionX = positionX;
		this.positionY = positionY;
		this.state = state;
		this.isDeleted = isDeleted;
		this.orders = orders;
	}

	public RestourantTables( @NotNull Integer floor, @NotNull Double positionX, @NotNull Double positionY, @NotNull TableStatus state, @NotNull Boolean isDeleted) {
		this.floor = floor;
		this.positionX = positionX;
		this.positionY = positionY;
		this.state = state;
		this.isDeleted = isDeleted;
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

	public RestourantTables setState(TableStatus state) {
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
			_orders.setRestourantTable(this);
			getOrders().add(_orders);
		}
		return this;
	}

	public RestourantTables unlinkOrders(Order _orders) {
		if (_orders != null) {
			_orders.setRestourantTable(null);
			getOrders().remove(_orders);
		}
		return this;
	}

	public RestourantTables unlinkOrders(Order _orders, Iterator<Order> it) {
		if (_orders != null) {
			_orders.setRestourantTable(null);
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return 115;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}