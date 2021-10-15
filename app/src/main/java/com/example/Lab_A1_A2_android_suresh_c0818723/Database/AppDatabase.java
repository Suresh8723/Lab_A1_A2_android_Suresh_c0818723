package com.example.Lab_A1_A2_android_suresh_c0818723.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.Lab_A1_A2_android_suresh_c0818723.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();

}
