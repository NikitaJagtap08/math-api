package com.assignment.mathapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@Component
@JsonPropertyOrder({ "message", "result" })
public class OutputResponse2{
    private Double result;
    private String message;

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return "OutputResponse2{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
