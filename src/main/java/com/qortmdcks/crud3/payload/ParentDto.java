package com.qortmdcks.crud3.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParentDto {
    private long id;

    @NotEmpty
    @Size(min = 2, message = "Post name should have at least 10characters")
    private String name;

    private Integer age;


    private String gender;
}
