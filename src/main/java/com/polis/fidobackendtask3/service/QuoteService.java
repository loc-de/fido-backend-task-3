package com.polis.fidobackendtask3.service;

import com.polis.fidobackendtask3.dtos.QuoteRequestCreate;
import com.polis.fidobackendtask3.dtos.QuoteRequestUpdate;
import com.polis.fidobackendtask3.dtos.QuoteResponse;
import com.polis.fidobackendtask3.mapper.QuoteRequestMapper;
import com.polis.fidobackendtask3.mapper.QuoteResponseMapper;
import com.polis.fidobackendtask3.models.Quote;
import com.polis.fidobackendtask3.repository.QuoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final QuoteResponseMapper responseMapper;
    private final QuoteRequestMapper requestMapper;

    public QuoteResponse getById(Integer id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Quote with id " + id + " not found")
        );
        return responseMapper.toDto(quote);
    }

    public List<QuoteResponse> getAll(String author, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Quote> quotesPage;

        if (author != null && !author.isBlank()) {
            quotesPage = quoteRepository.findByAuthor(author, pageable);
        } else {
            quotesPage = quoteRepository.findAll(pageable);
        }

        return quotesPage
                .getContent()
                .stream()
                .map(responseMapper::toDto)
                .toList();
    }

    public Integer create(QuoteRequestCreate quoteRequest) {
        return quoteRepository.save(requestMapper.toEntity(quoteRequest)).getId();
    }

    public void update(Integer id, QuoteRequestUpdate quoteRequest) {
        Quote quote = quoteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Quote with id " + id + " not found")
        );

        if (quoteRequest.getAuthor() != null)
            quote.setAuthor(quoteRequest.getAuthor());
        if (quoteRequest.getText() != null)
            quote.setText(quoteRequest.getText());

        quoteRepository.save(quote);
    }

    public void delete(Integer id) {
        quoteRepository.deleteById(id);
    }

}
