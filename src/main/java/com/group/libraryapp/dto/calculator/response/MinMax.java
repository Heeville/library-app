package com.group.libraryapp.dto.calculator.response;

import com.group.libraryapp.dto.calculator.request.NumberList;

import java.util.ArrayList;

public class MinMax {
    private int minimum;
    private int maximum;

    public MinMax(NumberList nu) {

        ArrayList<Integer> numlist=nu.getNumbers();
        this.minimum=numlist.get(0);
        this.maximum=numlist.get(0);

        for (int num:numlist){
            if(num<this.minimum){
                this.minimum=num;
            }
            if(num>this.maximum){
                this.maximum=num;
            }
        }

    }

    public int getMinumum() {
        return minimum;
    }


    public int getMaximum() {
        return maximum;
    }

}
