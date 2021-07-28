package com.example.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public @ToString class EmployeeDTO {
    @NotEmpty(message = "Name cannot be Empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    public String name;

    @Min(value = 500,message = "Min wage should be more than 500")
    public long salary;
    @Pattern(regexp = "male|female",message = "Gender needs to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd mmm yyyy")
    @NotNull(message = "Start Date can not be null")
    @PastOrPresent(message = "Start Date should be past or today's date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be empty")
    public String note;
    @NotBlank(message = "Profile pic cannot be empty")
    public String profilePic;
    @NotNull(message = "department should not be empty")
    public List<String> department;
}
