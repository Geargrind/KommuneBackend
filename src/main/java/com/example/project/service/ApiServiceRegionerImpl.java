package com.example.project.service;

import com.example.project.RegionRepository.RegionRepository;
import com.example.project.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceRegionerImpl implements ApiServiceRegioner {
    /*
     * Kan du forklar mig den her code igen.
     * */
    private final RestTemplate restTemplate;
    private final RegionRepository regionRepository;

    public ApiServiceRegionerImpl(RestTemplate restTemplate, RegionRepository regionRepository) {
        this.restTemplate = restTemplate;
        this.regionRepository = regionRepository;
    }

    private void saveRegioner(List<Region> regioners) {
        /*for (Region region : regioners) {
            regionRepository.save(region);
        }*/
        /*lambda-udtryk
         * */
        regioners.forEach(region -> regionRepository.save(region));

    }

    @Override
    public List<Region> getRegioner() {
        String regionUrl = "https://api.dataforsyningen.dk/regioner";

        /*
        The important part is here
        * */
        ResponseEntity<List<Region>> listResponseEntity =
                restTemplate.exchange(regionUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Region>>() {
                        });
        List<Region> regions = listResponseEntity.getBody();

        saveRegioner(regions);
        return regions;

    }

}
