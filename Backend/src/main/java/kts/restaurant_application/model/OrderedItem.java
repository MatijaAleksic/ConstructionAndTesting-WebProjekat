package kts.restaurant_application.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "_orderedItems")
@ApiModel(description = "")
public class OrderedItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(nullable = false)
	private State state;

	@NotNull
	@Column(nullable = false)
	private Integer number;

	@Column(nullable = true)
	private Integer price;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateTime;

	@NotNull
	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	@NotNull
	@Column(nullable = false)
	private String note;

	public OrderedItem() {
	}

	public OrderedItem(Long id, Long version, @NotNull String note, @NotNull State state, @NotNull Integer number, @NotNull Date dateTime, @NotNull Item item, @NotNull Staff staff, @NotNull Integer price) {
		this.id = id;
		this.version = version;
		this.state = state;
		this.number = number;
		this.dateTime = dateTime;
		this.item = item;
		this.staff = staff;
		this.note = note;
		this.price = price;
	}

	public Long getId(){
		return id;
	}



	public Integer getNumber() {
		return number;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public Item getItem() {
		return item;
	}

	public Staff getStaff() {
		return staff;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public OrderedItem setNumber(Integer number) {
		this.number = number;
		return this;
	}

	public OrderedItem setDateTime(Date dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public OrderedItem setItem(Item item) {
		this.item = item;
		return this;
	}

	public OrderedItem setStaff(Staff staff) {
		this.staff = staff;
		return this;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public OrderedItem linkItem(Item _item) {
		setItem(_item);
		return this;
	}

	public OrderedItem linkStaff(Staff _staff) {
		if (_staff != null) {
			_staff.getProcessed().add(this);
		}

		unlinkStaff();
		setStaff(_staff);
		return this;
	}

	public OrderedItem unlinkItem() {
		setItem(null);
		return this;
	}

	public OrderedItem unlinkStaff() {
		if (getStaff() != null) {
			getStaff().getProcessed().remove(this);
			setStaff(null);
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof OrderedItem && (getId().equals(((OrderedItem) obj).getId()));
	}

	@Override
	public int hashCode() {
		return 214;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}