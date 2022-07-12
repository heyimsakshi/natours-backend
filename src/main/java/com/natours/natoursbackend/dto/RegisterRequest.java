package com.natours.natoursbackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
