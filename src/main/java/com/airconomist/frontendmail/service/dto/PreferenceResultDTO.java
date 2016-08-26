package com.airconomist.frontendmail.service.dto;

import java.util.List;

/**
 * @author Zahari Dichev <zaharidichev@gmail.com>.
 */
public class PreferenceResultDTO {

    private String description;
    private List<String> preferenceIds;

    public PreferenceResultDTO() {
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPreferenceIds() {
        return preferenceIds;
    }
}
