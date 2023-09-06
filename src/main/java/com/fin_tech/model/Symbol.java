package com.fin_tech.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@JsonPropertyOrder({ "name", "companyName", "exchange", "industryCategory", "type" })
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Symbol {
    @Id
    String name;
    String companyName;
    String exchange;
    String industryCategory;
    String type;
}