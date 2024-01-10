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
public class Message {

    private String name;
    private String email;
    private String website;

}
