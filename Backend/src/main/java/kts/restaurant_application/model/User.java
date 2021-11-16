package kts.restaurant_application.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Table(name = "user_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(unique = false, nullable = true)
	private String firstName;

	@Column(unique = false, nullable = true)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = false, nullable = true)
	private String password;

	@Column(unique = false, nullable = true)
	private Date dateOfBirth;

	@Column(unique = false, nullable = true)
	private Long salary;

	@Column(unique = false, nullable = false)
	private boolean isDeleted;

	public User(Long id, String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.isDeleted = isDeleted;
	}

	public User() {

	}

	public User(String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.isDeleted = isDeleted;
	}

	public Long getId() {
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

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}