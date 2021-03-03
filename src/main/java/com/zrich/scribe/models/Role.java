package com.zrich.scribe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role {
    
    @Id
    @GeneratedValue
    private int id;

    private String role;
}
