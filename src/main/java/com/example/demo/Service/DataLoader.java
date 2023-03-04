package com.example.demo.Service;

import com.example.demo.Model.PepDTO;
import com.example.demo.Model.PepModel;
import com.example.demo.Repository.PepRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClients;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class DataLoader {

    private final PepRepository repository;

    public DataLoader(PepRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> saveJsonFromArchive() throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("D:\\pep.zip"));
        ZipEntry entry = zipInputStream.getNextEntry();
        if (entry != null && !entry.isDirectory() && entry.getName().endsWith(".json")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream, StandardCharsets.UTF_8));
            List<PepModel> people = new ObjectMapper().readValue(reader, new TypeReference<>() {});
            repository.saveAll(people);
        }
        zipInputStream.close();
        return ResponseEntity.ok("Download complete.");
    }
    public List<PepDTO> getByFullName(String fullName){
        return repository.findPepModelByFullName(fullName).stream().map(pep -> new PepDTO(
                pep.getId(), pep.getFirstName(), pep.getLast_name(), pep.getFirstNameEn(), pep.getPhoto()
        )).collect(Collectors.toList());
    }
    public List<PepModel> getTop10(){
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "task8");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("is_pep").is(true)),
                Aggregation.group("first_name").count().as("count"),
                Aggregation.sort(Sort.Direction.DESC, "count"),
                Aggregation.limit(10)
        );
        AggregationResults<PepModel> results = mongoOps.aggregate(
                aggregation, "task", PepModel.class
        );
        return results.getMappedResults();
    }
}