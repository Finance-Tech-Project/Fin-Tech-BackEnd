package com.fin_tech.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Symbol {
    @Id
    String name;
    String companyName;
    String exchange;
    String industryCategory;
    String type;

}