package com.example.demo.projections;

import org.springframework.beans.factory.annotation.Value;

public interface UserView {

    String getUsername();

    String getEmail();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
