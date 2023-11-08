package com.qortmdcks.crud3.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParentDto {
    private long id;

    @NotEmpty
    @Size(min = 2, message = "Post name should have at least 10characters")
    @Schema(description = "parent name")
    private String name;

    @Schema(description = "parent age")
    private Integer age;

    @Schema(description = "parent gender")
    private String gender;

    private Long childId;
}
