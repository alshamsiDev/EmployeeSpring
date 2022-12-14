package com.example.employeessoftwarespring;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.Year;

@Data
@AllArgsConstructor
public class Employee {
    @Min(value = 1, message = "Id")
    private int id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, message = "Name must be more than 2 characters")
    private String name;
    @Min(value = 4, message = "Age must be more than  4 years old")
    private int age;
    @NotNull
    @Min(value = 25, message = "Leave days must be more than 25 days")
    private int onLeave;
    @AssertFalse(message = "")
    private boolean employmentYear;
    @NotNull
    @Range(min = 2022, max = 2023, message = "Annual leave should be between 2022 and 2023")
    private int annualLeave;
}
