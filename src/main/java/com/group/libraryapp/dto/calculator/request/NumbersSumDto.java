package com.group.libraryapp.dto.calculator.request;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NumbersSumDto {

    private List<Integer> numbers;


    //@RequestBody 어노테이션은 요청 본문의 데이터를 지정된 Java 객체로 매핑할 때
    //해당 객체의 getter 메서드를 사용하여 값을 설정한다!!
//    public void setNumbers(List<Integer> numbers) {this.numbers = numbers;}

    /*public NumbersSumDto(List<Integer> numbers){
      this.numbers=numbers;
    }
    public NumbersSumDto(){

    }*/

    public int getSum(){
        int total=0;
        for (int num:numbers){
            total+=num;
        }
        return total;
    }

    //@RequestBody 어노테이션은 요청 본문의 데이터를 지정된 Java 객체로 매핑할 때
    //해당 객체의 getter 메서드를 사용하여 값을 설정한다!!
    public List<Integer> getNumbers() {
        return numbers;
    }
}
