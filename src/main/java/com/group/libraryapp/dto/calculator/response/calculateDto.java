package com.group.libraryapp.dto.calculator.response;

import com.group.libraryapp.dto.calculator.request.NumList;

public class calculateDto {
    public calculateDto(NumList cal) {
        this.add = cal.getNum1()+ cal.getNum2();
        this.minus = cal.getNum1()-cal.getNum2();
        this.multiply=cal.getNum1()*cal.getNum2();
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }

    private final int add;
    private final int minus;
    private final int multiply;


}
