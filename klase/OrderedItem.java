/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package klase;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAF9CZEscm2ODeQ= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAF9CZEscm2ODeQ= >>
// ----------- >>
public class OrderedItem {
	// ----------- << attribute.annotations@AAAAAAF9CZK032/34ZA= >>
	// ----------- >>
	private State state;

	// ----------- << attribute.annotations@AAAAAAF9CZLEIXA95Wc= >>
	// ----------- >>
	private Status status;

	// ----------- << attribute.annotations@AAAAAAF9CZSVQnOWt9A= >>
	// ----------- >>
	private Item item;

	// ----------- << attribute.annotations@AAAAAAF9CZXrMnjEqhA= >>
	// ----------- >>
	private Staff staff;

	public State getState() {
		return state;
	}

	public Status getStatus() {
		return status;
	}

	public Item getItem() {
		return item;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

// ----------- << class.extras@AAAAAAF9CZEscm2ODeQ= >>
// ----------- >>
}