package com.example.project.service;

import com.example.project.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiServiceKommuner {
  List<Kommune> getKommuner();
}
