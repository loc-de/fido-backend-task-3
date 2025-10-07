package com.polis.fidobackendtask3.repository;

import com.polis.fidobackendtask3.models.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    Page<Quote> findByAuthor(String author, Pageable pageable);

}
