package com.ggy.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trade")
public class Trade implements Serializable{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "account")
    private String account;

    @Column(name = "saving")
    private Double saving;

    @Column(name = "expend")
    private Double expend;

    @Column(name = "income")
    private Double income;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getSaving() {
        return saving;
    }

    public void setSaving(Double saving) {
        this.saving = saving;
    }

    public Double getExpend() {
        return expend;
    }

    public void setExpend(Double expend) {
        this.expend = expend;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
