package com.example.project.controller;

import com.example.project.RegionRepository.RegionRepository;
import com.example.project.model.Region;
import com.example.project.service.ApiServiceRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin // vigtig
@RestController
public class RegionRestController {
    @Autowired
    ApiServiceRegioner apiServiceRegioner;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    List<Region> getRegioner() {
        return apiServiceRegioner.getRegioner();
    }

    /*@GetMapping("/getregionerKommuner/kode")
    List<Region>getRegionerKommuner(@PathVariable("kode")String kode){
     return (List<Region> regionRepository.getReferenceById(kode));
    }*/

    @DeleteMapping("/region/{kode}")
     public ResponseEntity<String> deleteRegion(@PathVariable("kode") String kode) {
        Optional<Region>optionalRegion=regionRepository.findById(kode);
        if (optionalRegion.isPresent()) {
           regionRepository.deleteById(kode);
           return ResponseEntity.ok("Regions is delete");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("regions is not found");
        }
    }

}
