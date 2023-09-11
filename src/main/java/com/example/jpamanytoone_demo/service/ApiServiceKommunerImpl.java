package com.example.jpamanytoone_demo.service;

import com.example.jpamanytoone_demo.model.Kommune;
import com.example.jpamanytoone_demo.repository.KommuneRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceKommunerImpl implements ApiServiceKommuner{

    private final RestTemplate restTemplate;
    private final KommuneRepository kommuneRepository;

    public ApiServiceKommunerImpl(RestTemplate restTemplate, KommuneRepository kommuneRepository){
        this.restTemplate = restTemplate;
        this.kommuneRepository = kommuneRepository;
    }

    private void saveKommuner(List<Kommune> kommuneList){
        /*for (Region region:regions) {
            regionRepository.save(region);
        }*/
        //lambda-udtryk
        kommuneList.forEach(kommune -> kommuneRepository.save(kommune));
    }

    @Override
    public List<Kommune> getKommuner() {

        String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

        ResponseEntity<List<Kommune>> listResponseEntity =
                restTemplate.exchange(kommuneUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Kommune>>() {
                        });
        List<Kommune> kommuneList = listResponseEntity.getBody();
        saveKommuner(kommuneList);
        return kommuneList;
    }
}