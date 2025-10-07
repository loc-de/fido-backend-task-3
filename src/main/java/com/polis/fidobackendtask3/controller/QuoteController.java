package com.polis.fidobackendtask3.controller;

import com.polis.fidobackendtask3.dtos.QuoteRequestCreate;
import com.polis.fidobackendtask3.dtos.QuoteRequestUpdate;
import com.polis.fidobackendtask3.dtos.QuoteResponse;
import com.polis.fidobackendtask3.service.QuoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping("/{id}")
    public QuoteResponse getById(@PathVariable Integer id) {
        return quoteService.getById(id);
    }

    @GetMapping
    public List<QuoteResponse> getAll(
            @RequestParam(required = false) String author,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return quoteService.getAll(author, page, size);
    }

    @PostMapping
    public Integer create(@Valid @RequestBody QuoteRequestCreate request) {
        return quoteService.create(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @Valid @RequestBody QuoteRequestUpdate request) {
        quoteService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        quoteService.delete(id);
    }

}
