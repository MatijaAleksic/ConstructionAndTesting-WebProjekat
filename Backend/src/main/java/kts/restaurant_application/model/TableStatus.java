package kts.restaurant_application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TableStatus {
	@JsonProperty("free")
    free,
	@JsonProperty("ordeoccupiedred")
    occupied
}

