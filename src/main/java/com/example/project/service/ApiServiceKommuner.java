package com.example.project.service;

import com.example.project.model.Kommune;

import java.util.List;

public interface ApiServiceKommuner {
  List<Kommune> getKommuner();

String deleteKommune(String kode);

}
