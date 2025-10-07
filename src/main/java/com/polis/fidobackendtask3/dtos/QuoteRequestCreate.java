package com.polis.fidobackendtask3.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class QuoteRequestCreate {

    @NotBlank(message = "author cant be empty")
    @Size(max = 200, message = "author max 200 chars")
    private String author;

    @NotBlank(message = "text cant be empty")
    @Size(max = 1000, message = "text max 1000 chars")
    private String text;

}
