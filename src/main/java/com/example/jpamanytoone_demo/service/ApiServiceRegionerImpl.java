package com.example.jpamanytoone_demo.service;

import com.example.jpamanytoone_demo.model.Kommune;
import com.example.jpamanytoone_demo.model.Region;
import com.example.jpamanytoone_demo.repository.RegionRepository;
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

    @Autowired
    ApiServiceKommunerImpl apiServiceKommunerImpl;

    private final RestTemplate restTemplate;
    private final RegionRepository regionRepository;

    public ApiServiceRegionerImpl(RestTemplate restTemplate, RegionRepository regionRepository){
        this.restTemplate = restTemplate;
        this.regionRepository = regionRepository;
    }

    private void saveRegioner(List<Region> regions){
        /*for (Region region:regions) {
            regionRepository.save(region);
        }*/
        //lambda-udtryk
        regions.forEach(region -> regionRepository.save(region));
    }

    @Override
    public List<Region> getRegioner() {

        String regionUrl = "https://api.dataforsyningen.dk/regioner";

        // List<Region> regions = new ArrayList<>();

        ResponseEntity<List<Region>> listResponseEntity =
                restTemplate.exchange(regionUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Region>>() {
                        });
        List<Region> regions = listResponseEntity.getBody();
        saveRegioner(regions);
        return regions;
    }

    @Override
    public List<String> getKommunenavne(String kode) {
        List<String> kommuneNavne = new ArrayList<>();
        List<Kommune> kommuner = apiServiceKommunerImpl.getKommuner();
        for (int i = 0; i < kommuner.size() ; i++) {
         if (kommuner.get(i).getRegion().getKode().equals(kode)){
             kommuneNavne.add(kommuner.get(i).getNavn());
         }
        }
        return kommuneNavne;
    }


}