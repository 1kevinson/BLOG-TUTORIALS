package com.example.entity.database;

import com.example.entity.common.BaseEntityAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntityAudit {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}' +
                super.toString();
    }
}
