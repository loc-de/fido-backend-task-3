package com.polis.fidobackendtask3.mapper;

import com.polis.fidobackendtask3.dtos.QuoteResponse;
import com.polis.fidobackendtask3.models.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteResponseMapper {

    public QuoteResponse toDto(Quote quote) {
        if (quote == null) return null;

        QuoteResponse dto = new QuoteResponse();
        dto.setId(quote.getId());
        dto.setAuthor(quote.getAuthor());
        dto.setText(quote.getText());
        return dto;
    }
}