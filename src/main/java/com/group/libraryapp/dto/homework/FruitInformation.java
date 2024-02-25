package com.group.libraryapp.dto.homework;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class FruitInformation {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public void setWarehousingDate(LocalDate warehousingDate) {
        this.warehousingDate = warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    public void setSales(boolean sales) {
        this.sales = sales;
    }

    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean sales;

    public boolean getSales(){
        return sales;
    }
}
