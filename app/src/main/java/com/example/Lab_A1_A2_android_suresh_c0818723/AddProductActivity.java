package com.example.Lab_A1_A2_android_suresh_c0818723;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.Lab_A1_A2_android_suresh_c0818723.Database.DatabaseClient;

public class AddProductActivity extends AppCompatActivity {


    private EditText editTextProductName,
            editTextProductDesc,
            editTextProductPrice,
            editTextProviderName,
            editTextProviderEmail,
            editTextProviderPhone,
            editTextProviderLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        editTextProductName = findViewById(R.id.editTextProductName);
        editTextProductDesc = findViewById(R.id.editTextProductDesc);
        editTextProductPrice = findViewById(R.id.editTextProductPrice);
        editTextProviderName = findViewById(R.id.editTextProviderName);
        editTextProviderEmail = findViewById(R.id.editTextProviderEmail);
        editTextProviderPhone = findViewById(R.id.editTextProviderPhone);
        editTextProviderLocation = findViewById(R.id.editTextProviderLocation);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProduct();
            }
        });
    }

    public void saveProduct() {
        final String inputProductName = editTextProductName.getText().toString().trim();
        final String inputProductDesc = editTextProductDesc.getText().toString().trim();
        final String inputProductPrice = editTextProductPrice.getText().toString().trim();
        final String inputProviderName = editTextProviderName.getText().toString().trim();
        final String inputProviderEmail = editTextProviderEmail.getText().toString().trim();
        final String inputProviderPhone = editTextProviderPhone.getText().toString().trim();
        final String inputProviderLocation = editTextProviderLocation.getText().toString().trim();

        if (inputProductName.isEmpty()) {
            editTextProductName.setError("Product Name required");
            editTextProductName.requestFocus();
            return;
        }

        if (inputProductDesc.isEmpty()) {
            editTextProductDesc.setError("Product Description required");
            editTextProductDesc.requestFocus();
            return;
        }

        if (inputProductPrice.isEmpty()) {
            editTextProductPrice.setError("Product Price Required");
            editTextProductPrice.requestFocus();
            return;
        }
        if (inputProviderName.isEmpty()) {
            editTextProviderName.setError("Product Provider Name required");
            editTextProviderName.requestFocus();
            return;
        }

        if (inputProviderEmail.isEmpty()) {
            editTextProviderEmail.setError("Product Provider Email required");
            editTextProviderEmail.requestFocus();
            return;
        }

        if (inputProviderPhone.isEmpty()) {
            editTextProviderPhone.setError("Product Provider Phone Required");
            editTextProviderPhone.requestFocus();
            return;
        }

        if (inputProviderLocation.isEmpty()) {
            editTextProviderLocation.setError("Product Provider Location Required");
            editTextProviderLocation.requestFocus();
            return;
        }


        class SaveProduct extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a product
                Product product = new Product();
                product.setProductName(inputProductName);
                product.setProductDescription(inputProductDesc);
                product.setProductPrice(inputProductPrice);
                product.setProviderName(inputProviderName);
                product.setProviderEmail(inputProviderEmail);
                product.setProviderPhone(inputProviderPhone);
                product.setProviderLocation(inputProviderLocation);


                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .productDao()
                        .insert(product);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveProduct st = new SaveProduct();
        st.execute();
    }


}
