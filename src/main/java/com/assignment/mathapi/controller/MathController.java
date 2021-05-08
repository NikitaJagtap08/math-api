package com.assignment.mathapi.controller;

import com.assignment.mathapi.model.InputRequest;
import com.assignment.mathapi.model.OutputResponse;
import com.assignment.mathapi.model.OutputResponse2;
import com.assignment.mathapi.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math-api")
public class MathController {

    @Autowired
    MathService mathService;
    @Autowired
    OutputResponse outputResponse;
    @Autowired
    OutputResponse2 outputResponse2;

    @PostMapping(value = "/min/{value}",consumes = "application/json", produces = "application/json")
    ResponseEntity<?> findMin(@PathVariable Double value, @RequestBody InputRequest inputRequest) throws Exception {

        if(!mathService.checkIfValueExistInList(inputRequest.getListOfNumber(),value))
            throw  new Exception("Value ::"+value+" not present in the List");
        else {
            List<Double> minInList = mathService.findMinInList(inputRequest.getListOfNumber(), value);
            outputResponse.setMessage("List of numbers which are less than "+value+" are ");
            outputResponse.setNewList(minInList);
            outputResponse.setCount(minInList.size());
            return ResponseEntity.ok(outputResponse);
        }
    }
    @PostMapping(value = "/max/{value}",consumes = "application/json", produces = "application/json")
    ResponseEntity<?> findMax(@PathVariable Double value, @RequestBody InputRequest inputRequest) throws Exception {

        if(!mathService.checkIfValueExistInList(inputRequest.getListOfNumber(),value))
            throw  new Exception("Value ::"+value+" not present in the List");
        else {
            List<Double> maxInList = mathService.findMaxInList(inputRequest.getListOfNumber(), value);
            outputResponse.setMessage("List of numbers which are more than "+value+" are ");
            outputResponse.setNewList(maxInList);
            outputResponse.setCount(maxInList.size());
            return ResponseEntity.ok(outputResponse);
        }
    }
    @PostMapping(value = "/avg",consumes = "application/json", produces = "application/json")
    ResponseEntity<?> findAvg(@RequestBody InputRequest inputRequest) throws Exception {

        if(inputRequest.getListOfNumber().size()==0)
            throw  new Exception("No number in the list");
        else {
            outputResponse2.setMessage("average of input list");
            outputResponse2.setResult(mathService.findAvgForList(inputRequest.getListOfNumber()).getAsDouble());
            return ResponseEntity.ok(outputResponse2);
        }
    }
    @PostMapping(value = "/median",consumes = "application/json", produces = "application/json")
    ResponseEntity<?> findMedian(@RequestBody InputRequest inputRequest) throws Exception {

        if(inputRequest.getListOfNumber().size()==0)
            throw  new Exception("No number in the list");
        else {
            outputResponse2.setMessage("median of input list");
            outputResponse2.setResult(mathService.findMedianForList(inputRequest.getListOfNumber()));
            return ResponseEntity.ok(outputResponse2);
        }
    }
    @PostMapping(value = "/percentile/{value}",consumes = "application/json", produces = "application/json")
    ResponseEntity<?> findPercentile(@RequestBody InputRequest inputRequest,@PathVariable Double value) throws Exception {

        if(inputRequest.getListOfNumber().size()==0)
            throw  new Exception("No number in the list");
        else {
            outputResponse2.setMessage("Percentile of input list in %");
            outputResponse2.setResult(mathService.findPercentileForList(inputRequest.getListOfNumber(), value));
            return ResponseEntity.ok(outputResponse2);
        }
    }
}
