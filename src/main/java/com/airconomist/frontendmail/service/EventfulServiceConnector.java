package com.airconomist.frontendmail.service;

import com.airconomist.frontendmail.domain.email.EventsResponseDto;
import com.airconomist.frontendmail.service.dto.PreferenceRequestDTO;
import com.airconomist.rabbitmq.config.MqClient;
import com.airconomist.rabbitmq.config.RabbitConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EventfulServiceConnector {

    @Autowired
    private MqClient mqClient;

    public Optional<EventsResponseDto> getMatchingEvents(PreferenceRequestDTO request) {

        return mqClient
                .sendAndReceiveResponse(RabbitConstants.EVENT_EXCHANGE,
                        RabbitConstants.EVENT_QUEUE_NAME,
                        RabbitConstants.EVENT_KEY_NAME,
                        request,
                        EventsResponseDto.class);
    }

    public Optional<List<EventsResponseDto>> sendBulkAndGetOptionalList(List<PreferenceRequestDTO> request) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.EVENT_EXCHANGE,
                RabbitConstants.EVENT_QUEUE_NAME_GET_BULK,
                RabbitConstants.EVENT_KEY_NAME_GET_BULK,
                request,
                new TypeReference<List<EventsResponseDto>>() {
                }).map(result -> result.stream().
                filter(eventDto -> !eventDto.getPrefIdsToEvents().isEmpty()).collect(Collectors.toList())
        );
    }
}