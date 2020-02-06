package com.example.demo.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.time.LocalDate;
import java.util.Date;

@Component
@Scope("prototype")
public class Checkouts {

    @Autowired
    private Item soldItem;
    private String buyersName;
    private LocalDate selldate;

    public Item getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(Item soldItem) {
        this.soldItem = soldItem;
    }

    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    public LocalDate getSelldate() {
        return selldate;
    }

    public void setSelldate(LocalDate selldate) {
        this.selldate = selldate;
    }

    @Override
    public String toString() {
        return "Checkouts{" +
                "soldItem=" + soldItem +
                ", buyersName='" + buyersName + '\'' +
                ", selldate=" + selldate +
                '}';
    }
}
