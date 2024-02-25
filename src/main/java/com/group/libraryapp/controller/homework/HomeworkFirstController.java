package com.group.libraryapp.controller.homework;

import com.group.libraryapp.dto.calculator.request.*;
import com.group.libraryapp.dto.calculator.response.MinMax;
import com.group.libraryapp.dto.calculator.response.NumList2;
import com.group.libraryapp.dto.calculator.response.TodayDate;
import com.group.libraryapp.dto.calculator.response.calculateDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HomeworkFirstController {

    //문제 1
    @GetMapping("/api/v1/calc")
    public calculateDto Calculatelist(NumList request){
        return new calculateDto(request);
    }

    //문제 2
    @GetMapping("/api/v1/day-of-the-week")
    public TodayDate Datereturn(@RequestParam String date){
        return new TodayDate(date);
    }

    //문제 3
    @PostMapping("/api/v1/numbers")
    public int SumList(@RequestBody NumbersSumDto sumDto){
        return sumDto.getSum();
    }

    //리스트 요소 중 최대 최소 response
    @PostMapping("/api/v1/minmax")
    public MinMax minMax(@RequestBody NumberList numberList){

        return new MinMax(numberList);
    }

    @PostMapping("/api/v1/sumsum")
    public int SumSum(@RequestBody NumberList numberList){
        return numberList.getSum();
    }

    @PostMapping("/api/v1/sumsum2")
    public NumList2 SumSum2(@RequestBody NumberList numberList){

        return new NumList2(numberList.getNumbers());
    }


}
