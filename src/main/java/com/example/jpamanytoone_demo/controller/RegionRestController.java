package com.example.jpamanytoone_demo.controller;

import com.example.jpamanytoone_demo.model.Region;
import com.example.jpamanytoone_demo.repository.RegionRepository;
import com.example.jpamanytoone_demo.service.ApiServiceRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceRegioner apiServiceRegioner;
    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    List<Region> getRegioner(){

        return apiServiceRegioner.getRegioner();
    }


    @DeleteMapping("/region/{kode}")
    public ResponseEntity<String> deleteRegion(@PathVariable("kode") String kode){
        Optional<Region> optionalRegion = regionRepository.findById(kode);
        if(optionalRegion.isPresent()){
            regionRepository.deleteById(kode);
            return ResponseEntity.ok("Region deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }

    @GetMapping("/kommunenavne/{kode}")
    List<String> getKommunenavneFraRegion(@PathVariable("kode") String kode){
        return apiServiceRegioner.getKommunenavne(kode);
    }

}