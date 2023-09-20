package com.example.project.service;

import com.example.project.RegionRepository.KommuneRepository;
import com.example.project.model.Kommune;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceKommunerImpI implements ApiServiceKommuner {
    private final RestTemplate restTemplate;
    private final KommuneRepository kommuneRepository;

    public ApiServiceKommunerImpI(RestTemplate restTemplate, KommuneRepository kommuneRepository) {
        this.restTemplate = restTemplate;
        this.kommuneRepository = kommuneRepository;
    }

    private void saveKommuner(List<Kommune> kommuner) {
        kommuner.forEach(kommune -> kommuneRepository.save(kommune));
    }

    @Override
    public List<Kommune> getKommuner() {
        String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";
        //List<Kommune> kommuneList = new ArrayList<>();
        /*
        The important part is here
        * */
        ResponseEntity<List<Kommune>> listResponseEntity =
                restTemplate.exchange(kommuneUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Kommune>>() {
                });
        List<Kommune> kommuneList = listResponseEntity.getBody();
        saveKommuner(kommuneList);
        return kommuneList;
    }
}
