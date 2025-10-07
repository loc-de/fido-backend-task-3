package com.polis.fidobackendtask3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "author cant be empty")
    @Size(max = 200, message = "author max 200 chars")
    @Column(length = 200, nullable = false)
    private String author;

    @NotBlank(message = "text cant be empty")
    @Size(max = 1000, message = "text max 1000 chars")
    @Column(length = 1000, nullable = false)
    private String text;

}
