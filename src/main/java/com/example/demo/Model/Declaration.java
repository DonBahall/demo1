package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Declaration {
    @Id
    private String id;
    private String position_en;
    private String url;
    private String income;
    private String region_uk;
    private String office_en;
    private String position_uk;
    private String year;
    private String office_uk;
    private String region_en;
    private String family_income;
}
