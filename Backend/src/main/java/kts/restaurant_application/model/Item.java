package kts.restaurant_application.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "_items")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "type"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Food.class, name = "food"),
		@JsonSubTypes.Type(value = Drink.class, name = "drink")
})
@ApiModel(description = "")
public abstract class Item {
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
	@Column(nullable = false)
	private Byte priority;

	@NotNull
	@Column(nullable = false)
	private String subcategory;

	@NotNull
	@Column(nullable = false)
	private String description;

	@NotNull
	@Column(nullable = false)
	private Boolean isDeleted;

	@NotNull
	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(nullable = false)
	private Status status;

	public Long getId(){
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public Byte getPriority() {
		return priority;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public String getName() {
		return name;
	}

	public Item(Long id, Long version, @NotNull Double price, @NotNull Byte priority, @NotNull String subcategory, @NotNull String description, @NotNull Boolean isDeleted, @NotNull String name) {

		this.id = id;
		this.version = version;
		this.price = price;
		this.priority = priority;
		this.subcategory = subcategory;
		this.description = description;
		this.isDeleted = isDeleted;
		this.name = name;
	}

	public Item() {
	}

	public Item setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Item setPriority(Byte priority) {
		this.priority = priority;
		return this;
	}

	public Item setSubcategory(String subcategory) {
		this.subcategory = subcategory;
		return this;
	}

	public Item setDescription(String description) {
		this.description = description;
		return this;
	}

	public Item setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Item && (getId().equals(((Item) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 293;
	}

}