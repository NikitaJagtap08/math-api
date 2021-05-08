package com.assignment.mathapi.model;

import java.util.List;

public class InputRequest {
private List<Double> listOfNumber;

    public void setListOfNumber(List<Double> listOfNumber) {
        this.listOfNumber = listOfNumber;

    }
    public  List<Double> getListOfNumber()
    {
        return listOfNumber;}

    @Override
    public String toString() {
        return
                "Request{" +
                        "listOfNumber = '" + listOfNumber + '\'' +
                        "}";
    }
    }

