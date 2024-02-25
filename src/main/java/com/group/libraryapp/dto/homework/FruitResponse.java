package com.group.libraryapp.dto.homework;

public class FruitResponse {
    private long salesAmount;
    private long notSalesAmount;
    public FruitResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(long salesAmount) {
        this.salesAmount = salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }

    public void setNotSalesAmount(long notSalesAmount) {
        this.notSalesAmount = notSalesAmount;
    }
}
