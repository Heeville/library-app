package com.group.libraryapp.dto.calculator.response;

import java.util.ArrayList;
import java.util.List;

public class NumList2 {
    private List<Integer> numbers;

    public NumList2(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
