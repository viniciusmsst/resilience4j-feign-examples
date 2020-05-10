package com.viniciusmsst.resilience4jfeignexamples.fallback.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;

    @JsonProperty(value = "base_experience")
    private int baseExperience;

    private int height;

    @JsonProperty(value = "is_default")
    private boolean isDefault;

    private int order;
    private int weight;

    @JsonProperty(value = "location_area_encounters")
    private String locationAreaEncounters;
}
