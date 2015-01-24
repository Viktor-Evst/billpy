package com.vevstratov.billpy.domain;

import javax.persistence.*;

/**
 * Created by Viktor Evstratov on 24.01.15.
 */
@Entity
public class BillEntry {
    private Long id;
    private String name;
    private String text;
    private Integer amount;
    private Float pricePerUnit;
    private Bill bill;

    public BillEntry() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
