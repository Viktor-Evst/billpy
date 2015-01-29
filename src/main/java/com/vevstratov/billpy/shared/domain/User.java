package com.vevstratov.billpy.shared.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23.01.2015.
 */

@Entity
@Table(name = "`user`")
public class User implements IsSerializable {
    private Long id;
    private String firstname;
    private String lastname;
    private String name;  // login
    private String password;
    private List<Bill> bills = new ArrayList<>();

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String surname) {
        this.lastname = surname;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String login) {
        this.name = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
                ", surname='" + lastname + '\'' +
                '}';
    }
}
