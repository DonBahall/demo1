package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Data
public class PepModel {
    @Id
    private String id;
    @Field("last_job_title")
    private String last_job_title;
    @Field("last_name")
    private String last_name;
    @Field("wiki_uk")
    private String wiki_uk;
    @Field("photo")
    private String photo;
    @Field("reputation_convictions_en")
    private String reputationConvictionsEn;
    @Field("first_name_en")
    private String firstNameEn;
    @Field("last_workplace_en")
    private String lastWorkplaceEn;
    @Field("names")
    private String names;
    @Field("full_name")
    private String fullName;
    @Field("patronymic")
    private String patronymic;
    @Field("also_known_as_en")
    private String alsoKnownAsEn;
    @Field("reputation_manhunt_uk")
    private String reputationManhuntUk;
    @Field("first_name")
    private String firstName;
    @Field("declarations")
    private List<Declaration> declarations;
    @Field("reputation_sanctions_uk")
    private String reputationSanctionsUk;
    @Field("related_companies")
    private List<RelatedCompany> relatedCompanies;
    @Field("date_of_birth")
    private String dateOfBirth;
    @Field("patronymic_en")
    private String patronymicEn;
    @Field("reason_of_termination_en")
    private String reasonOfTerminationEn;
    @Field("reputation_assets_en")
    private String reputationAssetsEn;
    @Field("related_persons")
    private List<Relative> relatedPersons;
    @Field("reputation_convictions_uk")
    private String reputationConvictionsUk;
    @Field("reputation_crimes_en")
    private String reputationCrimesEn;
    @Field("reason_of_termination")
    private String reasonOfTermination;
    @Field("full_name_en")
    private String fullNameEn;
    @Field("city_of_birth")
    private String cityOfBirthUk;
    @Field("type_of_official")
    private String typeOfOfficial;
    private boolean died;
    @Field("last_name_en")
    private String lastNameEn;
    @Field("last_job_title_en")
    private String lastJobTitleEn;
    @Field("is_pep")
    private boolean isPep;
    @Field("reputation_manhunt_en")
    private String reputationManhuntEn;
    @Field("also_known_as_uk")
    private String alsoKnownAsUk;
    @Field("url")
    private String url;
    @Field("related_countries")
    private List<Related_countries> related_countries;
    @Field("termination_date_human")
    private String terminationDateHuman;
    @Field("last_workplace")
    private String lastWorkplace;
    @Field("city_of_birth_en")
    private String cityOfBirthEn;
    @Field("reputation_sanctions_en")
    private String reputationSanctionsEn;
    @Field("reputation_crimes_uk")
    private String reputationCrimesUk;
    @Field("wiki_en")
    private String wikiEn;
    @Field("reputation_assets_uk")
    private String reputationAssetsUk;
    @Field("type_of_official_en")
    private String typeOfOfficialEn;
    private String city_of_birth_uk;
}
