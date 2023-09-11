package com.example.jpamanytoone_demo.controller;

import com.example.jpamanytoone_demo.model.Kommune;
import com.example.jpamanytoone_demo.service.ApiServiceKommunerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceKommunerImpl apiServiceKommunerImpl;

    @GetMapping("/getkommuner")
    List<Kommune> getKommuner(){
        return apiServiceKommunerImpl.getKommuner();
    }

    //@GetMapping("/kommuner")
}