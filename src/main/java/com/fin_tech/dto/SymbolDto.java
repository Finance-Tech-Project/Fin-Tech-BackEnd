package com.fin_tech.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SymbolDto {

    String name;
    String companyName;
    String exchange;
    String industryCategory;
    String type;
}
