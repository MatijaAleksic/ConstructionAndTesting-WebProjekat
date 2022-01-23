package kts.restaurant_application.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import io.swagger.annotations.ApiModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "_users")
@Inheritance(strategy = InheritanceType.JOINED)
// @JsonTypeInfo(
// 		use = JsonTypeInfo.Id.NAME,
// 		property = "type"
// )
@JsonSubTypes({
		@JsonSubTypes.Type(value = Manager.class, name = "manager"),
		@JsonSubTypes.Type(value = Waiter.class, name = "waiter"),
		@JsonSubTypes.Type(value = Admin.class, name = "admin"),
		@JsonSubTypes.Type(value = MainCook.class, name = "mainCook"),
		@JsonSubTypes.Type(value = Barman.class, name = "barman")
})
@ApiModel(description = "")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@NotNull
	@Column(nullable = false)
	private String firstName;

	@NotNull
	@Column(nullable = false)

	private String lastName;

	@NotNull
	@Column(nullable = false, unique = true)
	private String username;

	@NotNull
	@Column(nullable = false)
	private String password;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@NotNull
	@Column(nullable = false)
	private Long salary;

	@NotNull
	@Column(nullable = false)
	private Boolean isDeleted;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;

	@Column(name = "last_password_reset_date")
	private Timestamp lastPasswordResetDate;

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

	public User(@NotNull String firstName, @NotNull String lastName, @NotNull String username, @NotNull String password, @NotNull Date dateOfBirth, @NotNull Long salary, @NotNull Boolean isDeleted) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.isDeleted = isDeleted;
	}

	public User(@NotNull String firstName, @NotNull String lastName, @NotNull String username, @NotNull String password, @NotNull Date dateOfBirth, @NotNull Long salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
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

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
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

	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

}