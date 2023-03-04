package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class RelatedCompany {
    @Id
    private String id;
    private String relationship_type_en;
    private String to_company_short_en;
    private String date_established;
    private String to_company_edrpou;
    private String to_company_founded;
    private String date_finished;
    private String to_company_is_state;
    private String share;
    private String date_confirmed;
    private String to_company_uk;
    private String to_company_short_uk;
    private String to_company_en;
    private String relationship_type_uk;
}
