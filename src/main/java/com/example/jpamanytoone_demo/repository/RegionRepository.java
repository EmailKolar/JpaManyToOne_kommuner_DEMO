package com.example.jpamanytoone_demo.repository;

import com.example.jpamanytoone_demo.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,String> {


}
