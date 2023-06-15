package com.mattkhaibeautysalon.www.MattKhaiBackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @NotBlank(message = "Firstname cannot be null")
    private String firstName;
    @NotBlank(message = "Lastname cannot be null")
    private String lastName;
    @Email
    private String email;
    @Size(min = 10, max = 15, message = "Phone number must be between 10-15 digits")
    private String phone;
}

