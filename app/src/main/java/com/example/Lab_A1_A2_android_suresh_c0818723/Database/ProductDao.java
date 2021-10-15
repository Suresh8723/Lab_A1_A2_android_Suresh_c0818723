package com.example.Lab_A1_A2_android_suresh_c0818723.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.Lab_A1_A2_android_suresh_c0818723.Product;

import java.security.Provider;
import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Insert
    void insert(Product product);


    @Delete
    void delete(Product product);

    @Update
    void update(Product product);

}
