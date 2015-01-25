package com.vevstratov.billpy.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */

@Entity
public class Bill {
    private Long id;
    private String text;
    private byte[] photo;
    private Date date;
    private Seller seller;
    private Buyer buyer;
    private List<BillEntry> entries;

    public Bill() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic(fetch = FetchType.LAZY)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @ManyToOne
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<BillEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BillEntry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", date=" + date +
                '}';
    }
}
