package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Related_countries {
    @Id
    private String id;
    private String date_established;
    private String date_finished;
    private String date_confirmed;
    private String to_country_en;
    private String to_country_uk;
    private String relationship_type;
}
