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
    private Double pricePerUnit;

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

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Transient
    public Double getTotal() {
        return getAmount() * getPricePerUnit();
    }

    @Override
    public String toString() {
        return "BillEntry{" +
                "pricePerUnit=" + pricePerUnit +
                ", amount=" + amount +
                ", text='" + text + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
