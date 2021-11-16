package kts.restaurant_application.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="maincook_table")
public class MainCook extends Cook {

    public MainCook(Long id, String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
        super(id, firstName, lastName, username, password, dateOfBirth, salary, isDeleted);
    }

    public MainCook() {

    }
}