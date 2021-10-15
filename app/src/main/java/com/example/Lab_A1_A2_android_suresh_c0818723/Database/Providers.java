package com.example.Lab_A1_A2_android_suresh_c0818723.Database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "providers_list")
public class Providers {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "provider_emailAddress")
    private String providersEmailAddress;

    @ColumnInfo(name = "provider_phoneNumber")
    private String providerPhoneNumber;

    @ColumnInfo(name = "location_coordiantes")
    private double locationCoordinates;

    @Ignore
    public Providers() {}

    public Providers(int id, @NonNull String name, String providersEmailAddress, String providerPhoneNumber, double locationCoordinates) {
        this.id = id;
        this.name = name;
        this.providersEmailAddress = providersEmailAddress;
        this.providerPhoneNumber = providerPhoneNumber;
        this.locationCoordinates = locationCoordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getProvidersEmailAddress() {
        return providersEmailAddress;
    }

    public void setProvidersEmailAddress(String providersEmailAddress) {
        this.providersEmailAddress = providersEmailAddress;
    }

    public String getProviderPhoneNumber() {
        return providerPhoneNumber;
    }

    public void setProviderPhoneNumber(String providerPhoneNumber) {
        this.providerPhoneNumber = providerPhoneNumber;
    }

    public double getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(double locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }
}
