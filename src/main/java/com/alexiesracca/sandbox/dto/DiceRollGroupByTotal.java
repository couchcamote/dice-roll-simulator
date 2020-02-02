package com.alexiesracca.sandbox.dto;

public class DiceRollGroupByTotal {

int total;

Long count;

    public DiceRollGroupByTotal()    {

    }

    public DiceRollGroupByTotal(int total, Long count)    {
        this.total = total;
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


    
}