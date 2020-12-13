package com.mygroup.springlearning.chapter4.example7.kindergarten;

import com.mygroup.springlearning.chapter4.example7.Food;
import com.mygroup.springlearning.chapter4.example7.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {

    public FoodProviderServiceImpl() {
        System.out.println("kindergarten");
    }
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet;
    }
}
