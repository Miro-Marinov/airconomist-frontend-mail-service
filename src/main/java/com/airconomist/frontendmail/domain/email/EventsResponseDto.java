package com.airconomist.frontendmail.domain.email;

import java.util.List;
import java.util.Map;

/**
 * @author Zahari Dichev <zaharidichev@gmail.com>.
 */
public class EventsResponseDto {

    private String tripId;
    private String locationId;
    Map<String, List<String>> prefIdsToEvents;

    public EventsResponseDto(String tripId, String locationId, Map<String, List<String>> prefIdsToEvents) {
        this.tripId = tripId;
        this.locationId = locationId;
        this.prefIdsToEvents = prefIdsToEvents;
    }

    public EventsResponseDto() {
    }

    public String getTripId() {
        return tripId;
    }

    public String getLocationId() {
        return locationId;
    }

    public Map<String, List<String>> getPrefIdsToEvents() {
        return prefIdsToEvents;
    }
}
