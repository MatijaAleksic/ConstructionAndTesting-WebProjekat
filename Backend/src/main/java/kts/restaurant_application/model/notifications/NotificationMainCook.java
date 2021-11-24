package kts.restaurant_application.model.notifications;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.Staff;
import kts.restaurant_application.model.State;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "_notifications_maincook")
public class NotificationMainCook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @NotNull
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @NotNull
    @Column(nullable = false)
    private String text;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private ItemAproval itemAproval;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dateTime;

    public NotificationMainCook(Long id, @NotNull Manager manager, @NotNull Item item, @NotNull String text, @NotNull ItemAproval itemAproval, @NotNull LocalDateTime dateTime) {
        this.id = id;
        this.manager = manager;
        this.item = item;
        this.text = text;
        this.itemAproval = itemAproval;
        this.dateTime = dateTime;
    }

    public NotificationMainCook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ItemAproval getItemAproval() {
        return itemAproval;
    }

    public void setItemAproval(ItemAproval itemAproval) {
        this.itemAproval = itemAproval;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
