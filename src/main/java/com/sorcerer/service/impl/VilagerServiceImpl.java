package com.sorcerer.service.impl;

import com.sorcerer.service.VilagerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilagerServiceImpl implements VilagerService {

    @Override
    public Double countVictims(List<Integer> ages, List<Integer> yearOfDeath) {
        Double sumBetweenYear = 0.0;
        try {
            for (int i = 0; i < yearOfDeath.size(); i++) {
                if (yearOfDeath.get(i) <= 0) {
                    throw new Exception(String.format("%s", -1));
                }
                if (ages.get(i) <= 0) {
                    throw new Exception(String.format("%s", -1));
                }
                sumBetweenYear += Double.valueOf(countVillager(yearOfDeath.get(i) - ages.get(i)));
            }
            return sumBetweenYear / yearOfDeath.size();
        }catch (Exception e){
            System.out.println(e);
            return -1.0;
        }
    }

    private Integer countVillager(Integer year){
        if(year<= 0){
            return 0;
        }
        return countVillager(year -1) + addNumber(year);
    }

    private Integer addNumber(Integer year){
        if(year<= 0){
            return 0;
        }
        if(year == 1){
            return 1;
        }

        return addNumber(year -1) + addNumber(year-2);
    }
}
