package com.example.project.service;

import com.example.project.model.Kommune;
import com.example.project.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiServiceRegioner {
    List<Region> getRegioner();
}
