package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.addDto;
import com.group.libraryapp.dto.calculator.request.multiplyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatoraController {

    @GetMapping("/add")
    public int AddController(addDto request ){
        return request.getNumber1()+ request.getNumber2();
    }

    @PostMapping("/multiply")
    public int MulController(@RequestBody multiplyDto request){
        return request.getNumber1()* request.getNumber2();
    }


}
