package com.vevstratov.billpy.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 23.01.2015.
 */
@Entity
public class Seller {
    private Long id;
    private String name;
    private List<Bill> bills;
    private List<Buyer> clients;

    public Seller() {
    }

    @Id
    @GeneratedValue
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

    @ManyToMany(mappedBy = "bills")
    public List<Buyer> getClients() {
        return clients;
    }

    public void setClients(List<Buyer> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
