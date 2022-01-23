package kts.restaurant_application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum State {
	@JsonProperty("ordered")
	ordered,
	@JsonProperty("inMaking")
	inMaking,
	@JsonProperty("finished")
	finished,
	@JsonProperty("delivered")
	delivered;
}