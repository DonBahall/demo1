package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Relative {
    @Id
    private String id;
    @JsonProperty
    private String relationship_type_en;
    private String date_established;
    private String person_en;
    private String date_confirmed;
    private String is_pep;
    private String date_finished;
    private String person_uk;
    private String relationship_type;
}
