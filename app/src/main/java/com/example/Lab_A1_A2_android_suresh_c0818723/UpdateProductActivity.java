package com.example.Lab_A1_A2_android_suresh_c0818723;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Lab_A1_A2_android_suresh_c0818723.Database.DatabaseClient;

public class UpdateProductActivity extends AppCompatActivity {

    private EditText editTextProductName,editTextProductDescription,editTextProductPrice,
            editTextProviderName,editTextProviderEmail,editTextProviderPhone,editTextProviderLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);


        editTextProductName = findViewById(R.id.editTextProductName);
        editTextProductDescription = findViewById(R.id.editTextProductDesc);
        editTextProductPrice = findViewById(R.id.editTextProductPrice);

        editTextProviderName = findViewById(R.id.editTextProviderName);
        editTextProviderEmail = findViewById(R.id.editTextProviderEmail);
        editTextProviderPhone = findViewById(R.id.editTextProviderPhone);
        editTextProviderLocation = findViewById(R.id.editTextProviderLocation);


        final Product product = (Product) getIntent().getSerializableExtra("product");

        loadProduct(product);

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                updateProduct(product);
            }
        });

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateProductActivity.this);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteProduct(product);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
            }
        });
    }

    private void loadProduct(Product product) {
        editTextProductName.setText(product.getProductName());
        editTextProductDescription.setText(product.getProductDescription());
        editTextProductPrice.setText(product.getProductPrice());
        editTextProviderName.setText(product.getProviderName());
        editTextProviderEmail.setText(product.getProviderEmail());
        editTextProviderPhone.setText(product.getProviderPhone());
        editTextProviderLocation.setText(product.getProviderLocation());
    }

    private void updateProduct(final Product product) {
        final String inputProductName = editTextProductName.getText().toString().trim();
        final String inputProductDesc = editTextProductDescription.getText().toString().trim();
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
            editTextProductDescription.setError("Product Description required");
            editTextProductDescription.requestFocus();
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

        class UpdateProduct extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                product.setProductName(inputProductName);
                product.setProductDescription(inputProductDesc);
                product.setProductPrice(inputProductPrice);
                product.setProviderName(inputProviderName);
                product.setProviderEmail(inputProviderEmail);
                product.setProviderPhone(inputProviderPhone);
                product.setProviderLocation(inputProviderLocation);
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .productDao()
                        .update(product);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UpdateProductActivity.this, MainActivity.class));
            }
        }

        UpdateProduct ut = new UpdateProduct();
        ut.execute();
    }


    private void deleteProduct(final Product product) {
        class DeleteProduct extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .productDao()
                        .delete(product);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UpdateProductActivity.this, MainActivity.class));
            }
        }

        DeleteProduct dt = new DeleteProduct();
        dt.execute();

    }

}
