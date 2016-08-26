package com.airconomist.frontendmail.service.dto;

/**
 * @author Zahari Dichev <zaharidichev@gmail.com>.
 */
public class PreferenceRequestDTO {

    private String locationId;
    private Long fromDate;
    private Long toDate;
    private String tripId;

    public String getTripId() {
        return tripId;
    }

    public String getLocationId() {
        return locationId;
    }

    public Long getFromDate() {
        return fromDate;
    }

    public Long getToDate() {
        return toDate;
    }

    public static class Builder {

        private PreferenceRequestDTO dto;

        public Builder withLocationId(String locationId) {
            this.dto.locationId = locationId;
            return this;
        }

        public Builder withFrom(Long from) {
            this.dto.fromDate = from;
            return this;
        }

        public Builder withTo(Long to) {
            this.dto.toDate = to;
            return this;
        }

        public PreferenceRequestDTO builder() {
            return this.dto;
        }
    }
}
