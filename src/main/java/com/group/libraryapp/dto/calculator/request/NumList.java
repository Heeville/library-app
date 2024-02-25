package com.group.libraryapp.dto.calculator.request;

public class NumList {
    private final int num1;
    private final int num2;

    public int getNum2() {
        return num2;
    }

    public int getNum1() {
        return num1;
    }

    public NumList(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
