package com.example.demo.Controller;

import com.example.demo.Model.PepDTO;
import com.example.demo.Model.PepModel;
import com.example.demo.Repository.PepRepository;
import com.example.demo.Service.DataLoader;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class PepController {

    private final DataLoader loader;
    private final PepRepository repository;

    public PepController(DataLoader loader, PepRepository repository) {
        this.loader = loader;
        this.repository = repository;
    }

    @RequestMapping(value = "/uploadData", method = RequestMethod.POST)
    public String uploadData() throws IOException {
        repository.deleteAll();
        if (loader.saveJsonFromArchive().getStatusCode().is2xxSuccessful()) {
            return "Success download data";
        } else return "Error download data";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<PepDTO> findByFullName(@RequestParam String fullName) {
        return loader.getByFullName(fullName);
    }

    @RequestMapping(value = "/top10", method = RequestMethod.GET)
    public List<PepModel> findTop10Famous(){
        return loader.getTop10();
    }
}
