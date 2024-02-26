package com.group.libraryapp.dto.homework;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class FruitInformation {

    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean sales;
    @JsonIgnore
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getSales(){
        return sales;
    }
}
