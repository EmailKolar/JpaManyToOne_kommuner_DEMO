package com.example.jpamanytoone_demo.service;

import com.example.jpamanytoone_demo.model.Region;

import java.util.List;

public interface ApiServiceRegioner {
    List<Region> getRegioner();
    List<String> getKommunenavne(String kode);
}