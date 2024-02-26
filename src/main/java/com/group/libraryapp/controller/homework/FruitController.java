package com.group.libraryapp.controller.homework;

import com.group.libraryapp.dto.homework.FruitId;
import com.group.libraryapp.dto.homework.FruitInformation;
import com.group.libraryapp.dto.homework.FruitResponse;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final FruitService fruitService;
    //private final JdbcTemplate jdbcTemplate;

    public FruitController(FruitService fruitService){
        this.fruitService=fruitService;
    }

    //문제1
    @PostMapping("/api/v1/fruit")
    public FruitInformation fruitInformation(@RequestBody FruitInformation information){
        return fruitService.saveInformation(information);
    }

    //문제2
    @PutMapping("/api/v1/fruit")
    public void fruitId(@RequestBody FruitId fruitId){
        fruitService.fruitId(fruitId.getId());
    }

    //문제3
    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse fruitResponse(@RequestParam String name){
        return fruitService.SalasPrice(name);
    }



}
