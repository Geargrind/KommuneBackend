package com.example.project.RegionRepository;

import com.example.project.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface KommuneRepository extends JpaRepository<Kommune,String> {


}
