package com.example.entity.database;

import com.example.entity.common.BaseEntityAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends BaseEntityAudit {

    private String login;
    private String email;
    private String name;
}
