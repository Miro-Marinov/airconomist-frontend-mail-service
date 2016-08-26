package com.airconomist.frontendmail.service.dto;

import java.util.List;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class BulkRequestDto {

    List<PreferenceRequestDTO> requests;

    public BulkRequestDto() {
    }

    public BulkRequestDto(List<PreferenceRequestDTO> requests) {
        this.requests = requests;
    }

    public List<PreferenceRequestDTO> getRequests() {
        return requests;
    }
}
