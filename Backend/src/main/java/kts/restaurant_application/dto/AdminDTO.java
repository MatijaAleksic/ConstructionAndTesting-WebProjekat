package Backend.src.main.java.kts.restaurant_application.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdminDTO {


    @NotBlank(message = "ID cannot be empty.")
    private Long id;
    private String firstName;
    private String lastName;
    @NotBlank(message = "Username cannot be empty.")
    private String username;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private Long salary;
    private boolean isDeleted;

    public AdminDTO(@NotBlank(message = "ID cannot be empty.") Long id, String firstName, String lastName, @NotBlank(message = "Username cannot be empty.") String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.isDeleted = isDeleted;
    }

    public AdminDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
