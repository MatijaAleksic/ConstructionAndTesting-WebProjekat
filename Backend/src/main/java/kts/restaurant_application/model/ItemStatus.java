package kts.restaurant_application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ItemStatus {
	@JsonProperty("newItem")
	newItem,
	@JsonProperty("active")
	active,
	@JsonProperty("inactive")
	inactive;
}