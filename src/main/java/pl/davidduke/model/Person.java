package pl.davidduke.model;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    long id;
    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    String name;
    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 120, message = "Age should be less than 120")
    int age;
    @NotBlank(message = "Email should not be empty")
    @Email(message = "Invalid email")
    String email;
}
