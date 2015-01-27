package com.vevstratov.billpy.shared.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23.01.2015.
 */
@Entity
public class Seller {
    private Long id;
    private String name;
    private List<Bill> bills = new ArrayList<Bill>();

    public Seller() {
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

    @OneToMany
    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
