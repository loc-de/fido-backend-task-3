package com.polis.fidobackendtask3.mapper;

import com.polis.fidobackendtask3.dtos.QuoteRequestCreate;
import com.polis.fidobackendtask3.models.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteRequestMapper {

    public Quote toEntity(QuoteRequestCreate quoteRequest) {
        if (quoteRequest == null) {
            return null;
        }

        return Quote.builder()
                .author(quoteRequest.getAuthor())
                .text(quoteRequest.getText())
                .build();
    }

}
