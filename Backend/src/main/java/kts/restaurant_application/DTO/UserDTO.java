package kts.restaurant_application.DTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {

    private Long id;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email format is not valid.")
    private String username;

    @NotBlank(message = "Password cannot be empty.")
    private String password;

    @NotBlank(message = "Firstname cannot be empty.")
    private String firstName;

    @NotBlank(message = "Lastname cannot be empty.")
    private String lastName;

    @NotBlank(message = "Date of birth cannot be empty.")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotBlank(message = "Salary cannot be empty.")
    private Long salary;

    public UserDTO() {
    }

    public UserDTO(Long id, @NotBlank(message = "Email cannot be empty.") @Email(message = "Email format is not valid.") String username, @NotBlank(message = "Password cannot be empty.") String password, @NotBlank(message = "Firstname cannot be empty.") String firstName, @NotBlank(message = "Lastname cannot be empty.") String lastName, @NotBlank(message = "Date of birth cannot be empty.") Date dateOfBirth, @NotBlank(message = "Salary cannot be empty.") Long salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
