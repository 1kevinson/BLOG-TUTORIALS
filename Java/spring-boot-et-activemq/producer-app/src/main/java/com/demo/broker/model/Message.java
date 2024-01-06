package com.demo.broker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class Message implements Serializable {

    // Regular expression for a simple website URL
    private static final String WEBSITE_PATTERN =
    "^(http|https)://([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,6})(:[0-9]+)?(/.*)?$";

    @NotNull
    @Size(max = 50, message = "Name must be 50 characters max")
    private String name;

    @Email(message = "Must be a valid email provided")
    private String email;

    @Pattern(regexp = WEBSITE_PATTERN, message = "Invalid website format")
    private String website;

}
