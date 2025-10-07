package com.polis.fidobackendtask3.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuoteResponse {

    private Integer id;
    private String author;
    private String text;

}
