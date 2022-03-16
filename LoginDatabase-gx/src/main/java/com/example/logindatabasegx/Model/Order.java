package com.example.logindatabasegx.Model;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Order {
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty product;
    private SimpleStringProperty label;
    private SimpleStringProperty date;
    private SimpleStringProperty price;

    public Order(String firstname, String lastname, String product, String label
            , String date, String price) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.product = new SimpleStringProperty(product);
        this.label = new SimpleStringProperty(label);
        this.date = new SimpleStringProperty(date);
        this.price = new SimpleStringProperty(price);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getProduct() {
        return product.get();
    }

    public SimpleStringProperty productProperty() {
        return product;
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public String getLabel() {
        return label.get();
    }

    public SimpleStringProperty labelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
