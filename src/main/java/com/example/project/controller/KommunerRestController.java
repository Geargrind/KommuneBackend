package com.example.project.controller;

import com.example.project.model.Kommune;
import com.example.project.service.ApiServiceKommunerImpI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class KommunerRestController {
    @Autowired
    ApiServiceKommunerImpI apiServiceKommunerImpI;

    @GetMapping("/getKommuner")
    List<Kommune> getKommuner(){
      return  apiServiceKommunerImpI.getKommuner();
    }


}
