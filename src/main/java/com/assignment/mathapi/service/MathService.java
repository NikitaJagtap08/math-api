package com.assignment.mathapi.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class MathService {
    public List<Double>  findMinInList(List<Double> integerList, Double value){
        Collections.sort(integerList);
        int indexOfValue = integerList.indexOf(value);
        List<Double> ListOfNumberSmallerThanValue = integerList.subList(0,indexOfValue);
        return ListOfNumberSmallerThanValue;
    }
    public List<Double> findMaxInList(List<Double> integerList, Double value){
        Collections.sort(integerList);
        int indexOfValue = integerList.indexOf(value);
        List<Double>  ListOfNumberGreaterThanValue = integerList.subList(indexOfValue+1,integerList.size());
        return ListOfNumberGreaterThanValue;
    }
    public OptionalDouble findAvgForList(List<Double> integerList){
        OptionalDouble average = integerList.stream().mapToDouble(n -> n).average();
        return average;
    }
    public  Double findMedianForList(List<Double> integerList)
    {
        Collections.sort(integerList);
        int size=integerList.size();
        int middleIndex=(size / 2);
        System.out.println("size::"+size);
        System.out.println("middleIndex=::"+middleIndex);
        if(size%2==1) {
            return integerList.get(middleIndex);
        }
        else {
            return (integerList.get(middleIndex) + integerList.get(middleIndex - 1)) / (2.0);
        }

    }
    public Double findPercentileForList(List<Double> integerList,Double value)
    {
        List<Double> minInList = findMinInList(integerList, value);
        return (minInList.size()*100.0/integerList.size());
    }

    public boolean checkIfValueExistInList(List<Double> integerList,Double value)
    {
        return integerList.contains(value);
    }
}
