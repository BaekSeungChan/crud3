package com.qortmdcks.crud3.payload;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChildDto {
    private long id;

    @NotEmpty
    @Size(min = 2, message = "Child name should have at least 10 characters")
    private String name;

    private int age;

    @NotEmpty
    private String student;
}
