package com.example.project_default_jsp.repository;

import com.example.project_default_jsp.model.SandwichCondiments;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SandwichCondimentsRepo implements ISandwichCondimentsRepo{
    private static List<SandwichCondiments> sandwichCondimentsList = new ArrayList<>();
    static {
        sandwichCondimentsList.add(new SandwichCondiments(1,"Lettuce"));
        sandwichCondimentsList.add(new SandwichCondiments(1,"Tomato"));
        sandwichCondimentsList.add(new SandwichCondiments(1,"Mustard"));
        sandwichCondimentsList.add(new SandwichCondiments(1,"Sprouts"));
    }

    @Override
    public List<SandwichCondiments> displayAll() {
        return sandwichCondimentsList;
    }
}
