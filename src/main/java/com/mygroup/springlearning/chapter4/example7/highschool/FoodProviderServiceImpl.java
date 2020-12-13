package com.mygroup.springlearning.chapter4.example7.highschool;

import com.mygroup.springlearning.chapter4.example7.Food;
import com.mygroup.springlearning.chapter4.example7.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {

    public FoodProviderServiceImpl() {
        System.out.println("highschool");
    }

    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
