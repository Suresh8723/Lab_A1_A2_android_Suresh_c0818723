package com.example.Lab_A1_A2_android_suresh_c0818723;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "product_name")
    private String productName;

    public Product(int id, String productName, String productDescription, String productPrice, String providerName, String providerEmail, String providerPhone, String providerLocation) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.providerName = providerName;
        this.providerEmail = providerEmail;
        this.providerPhone = providerPhone;
        this.providerLocation = providerLocation;
    }

    @ColumnInfo(name = "product_desc")
    private String productDescription;

    @ColumnInfo(name = "product_price")
    private String productPrice;

    @ColumnInfo(name = "provider_name")
    private String providerName;

    @ColumnInfo(name = "provider_email")
    private String providerEmail;

    @ColumnInfo(name = "provider_phone")
    private String providerPhone;

    @ColumnInfo(name = "provider_location")
    private String providerLocation;

    public Product() {

    }


    /*
    * Getters and Setters
    * */

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
    }
}
