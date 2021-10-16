package com.example.Lab_A1_A2_android_suresh_c0818723.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.security.Provider;
import java.util.List;

@Dao
public interface ProvidersDao {

    @Insert
    void insertProvider(Provider provider);

    @Query("DELETE FROM providers_list")
    void deleteAllProviders();

    @Query("DELETE FROM providers_list WHERE id= :id")
    void deleteProvider(int id);

    @Query("UPDATE providers_list SET provider_name = :name, provider_emailAddress = :emailAddress, provider_phoneNumber = :phoneNumber, location_coordiantes = :locationCoordiantes")
    int updateProvider(int id, String name, String emailAddress, String phoneNumber, double locationCoordiantes);

    @Query("SELECT * FROM providers_list ORDER BY provider_name")
    List<Providers> getAllProviders();

    @Query("SELECT * FROM providers_list WHERE id == :id")
    LiveData<Providers> getProvider(int id);

    @Update
    void update(Providers providers);

    @Delete
    void delete(Providers providers);

    @Insert
    void insert(Providers providers);
}
