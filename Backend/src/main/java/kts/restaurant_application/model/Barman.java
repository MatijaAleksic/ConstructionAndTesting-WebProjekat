package Backend.src.main.java.kts.restaurant_application.model;



import java.util.Date;

import javax.persistence.Entity;

@Entity
@Table(name="barman_table")
public class Barman extends Staff {

    public Barman(Long id, String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
        super(id, firstName, lastName, username, password, dateOfBirth, salary, isDeleted);
    }

    public Barman() {
        super();
    }
}