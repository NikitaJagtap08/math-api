package com.assignment.mathapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@JsonPropertyOrder({ "message", "count", "newList" })
public class OutputResponse {
    @JsonProperty("count")
    private int count;

    @JsonProperty("newList")
    private List<Double> newList;

    @JsonProperty("message")
    private String message;

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setNewList(List<Double> newList){
        this.newList = newList;
    }

    public List<Double> getNewList(){
        return newList;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return "OutputResponse{" + "count = '" + count + '\'' + ",newList = '" + newList + '\'' + ",message = '" + message + '\'' + "}";
    }
}
