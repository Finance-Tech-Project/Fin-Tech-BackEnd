package com.fin_tech.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "stock_quotes")
public class Symbol {
    @Id
    String name;
    String companyName;
    String exchange;
    String industryCategory;
    String type;

}