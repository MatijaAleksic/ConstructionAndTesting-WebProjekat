package kts.restaurant_application.model;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.Staff;
import kts.restaurant_application.model.State;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "_notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column(nullable = false)
    private String text;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private UserTypes userType;


    public Notification(Long id, @NotNull String text, @NotNull LocalDateTime dateTime, @NotNull UserTypes userType) {
        this.id = id;
        this.text = text;
        this.dateTime = dateTime;
        this.userType = userType;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }
}
