package com.example.demo.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.exception.validator.Author;
import lombok.Data;

@Data
public class BookDto {

    @Size(min = 2, message = "Not a name")
    @NotEmpty(message = "Please provide a name")
    private String name;

    @Author
    @NotEmpty(message = "Please provide an author")
    private String author;

    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$")
    private String isbn;

    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private BigDecimal price;

}
