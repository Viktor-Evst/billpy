package com.vevstratov.billpy.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */

@Entity
public class Bill {
    private Long id;
    private String text;
    private Double amount;
    private byte[] photo;
    private Date date;
    private Seller seller;
    private Buyer buyer;

    public Bill() {
    }

    @Id
    @GeneratedValue
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", amount=" + amount +
                ", photo=" + Arrays.toString(photo) +
                ", date=" + date +
                ", seller=" + seller.getName() +
                ", user=" + buyer.getName() +
                '}';
    }
}
