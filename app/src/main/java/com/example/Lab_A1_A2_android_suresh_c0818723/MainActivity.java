package com.example.Lab_A1_A2_android_suresh_c0818723;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Lab_A1_A2_android_suresh_c0818723.Database.DatabaseClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private FloatingActionButton buttonAddProduct;
    private RecyclerView recyclerView;
    static boolean msgShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAddProduct = findViewById(R.id.floating_button_add);

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });

        getProducts();
    }

    private void getProducts() {
        class ProductList extends AsyncTask<Void, Void, List<Product>> {

            @Override
            protected List<Product> doInBackground(Void... voids) {
                List<Product> productList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .productDao()
                        .getAll();
                return productList;
            }

            @Override
            protected void onPostExecute(List<Product> products) {
                super.onPostExecute(products);
                ProductAdapter productAdapter = new ProductAdapter(MainActivity.this, products);
                recyclerView.setAdapter(productAdapter);
            }
        }

        ProductList gt = new ProductList();
        gt.execute();
    }

}