package com.qortmdcks.crud3.payload;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChildDto {
    private long id;

    @NotEmpty
    @Size(min = 2, message = "Child name should have at least 10 characters")
    @Schema(description = "child name")
    private String name;

    @Schema(description = "child age")
    private int age;

    @NotEmpty
    @Schema(description = "child student")
    private String student;
}
