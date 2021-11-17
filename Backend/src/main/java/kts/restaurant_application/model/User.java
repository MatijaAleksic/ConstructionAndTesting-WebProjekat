package kts.restaurant_application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "_users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "type"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Manager.class, name = "manager"),
		@JsonSubTypes.Type(value = Waiter.class, name = "waiter"),
		@JsonSubTypes.Type(value = Admin.class, name = "admin"),
		@JsonSubTypes.Type(value = MainCook.class, name = "mainCook"),
		@JsonSubTypes.Type(value = Barman.class, name = "barman")
})
@ApiModel(description = "")
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	@NotNull
	@Column(nullable = true)
	private String firstName;

	@NotNull
	@Column(nullable = true)

	private String lastName;

	@NotNull
	@Column(nullable = false, unique = true)
	private String username;

	@NotNull
	@Column(nullable = false)
	private String password;

	@NotNull
	@Column(nullable = true)
	private Date dateOfBirth;

	@NotNull
	@Column(nullable = true)
	private Long salary;

	@NotNull
	@Column(nullable = false)
	private Boolean isDeleted;

	public User() {
	}

	public User(Long id, Long version, @NotNull String firstName, @NotNull String lastName, @NotNull String username, @NotNull String password, @NotNull Date dateOfBirth, @NotNull Long salary, @NotNull Boolean isDeleted) {
		this.id = id;
		this.version = version;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.isDeleted = isDeleted;
	}

	public Long getId(){
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Long getSalary() {
		return salary;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public User setSalary(Long salary) {
		this.salary = salary;
		return this;
	}

	public User setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof User && (getId().equals(((User) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 218;
	}

}