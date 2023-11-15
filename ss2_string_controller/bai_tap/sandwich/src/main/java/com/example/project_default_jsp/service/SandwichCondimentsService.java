package com.example.project_default_jsp.service;

import com.example.project_default_jsp.model.SandwichCondiments;
import com.example.project_default_jsp.repository.ISandwichCondimentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichCondimentsService implements ISandwichCondimentsService {
    @Autowired
    private ISandwichCondimentsRepo sandwichCondimentsRepo;

    @Override
    public List<SandwichCondiments> displayAll() {
        return sandwichCondimentsRepo.displayAll();
    }
}
