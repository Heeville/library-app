package com.group.libraryapp.dto.calculator.request;

import java.util.ArrayList;

public class NumberList {
    ArrayList<Integer> numbers;




    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public int getSum(){
        int sum=0;
        for (int num:numbers){
            sum+=num;
        }
        return sum;
    }

}
