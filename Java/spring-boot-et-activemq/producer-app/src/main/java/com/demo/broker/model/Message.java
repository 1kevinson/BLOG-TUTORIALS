package com.demo.broker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Message implements Serializable {

    private String name;
    private String email;
    private String website;

}
