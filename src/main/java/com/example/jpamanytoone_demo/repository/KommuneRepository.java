package com.example.jpamanytoone_demo.repository;

import com.example.jpamanytoone_demo.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommuneRepository extends JpaRepository<Kommune, String> {
}
