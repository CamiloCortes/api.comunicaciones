package com.mercadolibre.apigetmessagealert.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * clase utilizada para mapear los objetos de tipo Satellite
 * @author ccortes5 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "distance", "message" })
public class Satellite {

	@JsonProperty("name")
	private String name;
	@JsonProperty("distance")
	private Double distance;
	@JsonProperty("message")
	private List<String> message = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("distance")
	public Double getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@JsonProperty("message")
	public List<String> getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(List<String> message) {
		this.message = message;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
