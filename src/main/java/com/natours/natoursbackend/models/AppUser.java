package com.natours.natoursbackend.models;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class AppUser {

    @Id
    private String id;

    @Field("name")
    @NotBlank(message = "Full Name Is Required!")
    private String name;

    @Field("email")
    @NotBlank(message = "Email Address Is Required")
    @Email(message="Given Email Address Is Not Valid Email Address, Please Enter Valid One.")
    private String email;

    @Field("password")
    @NotBlank(message="Password is required")
    private String password;

    private Instant createdDate; //User Creation Date.
}
