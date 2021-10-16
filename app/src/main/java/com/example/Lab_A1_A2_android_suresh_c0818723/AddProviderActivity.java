package com.example.Lab_A1_A2_android_suresh_c0818723;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Lab_A1_A2_android_suresh_c0818723.Database.DatabaseClient;
import com.example.Lab_A1_A2_android_suresh_c0818723.Database.Providers;

public class AddProviderActivity extends AppCompatActivity {
    private EditText
            editTextProviderName,
            editTextProviderEmail,
            editTextProviderPhone,
            editTextProviderLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider);

        editTextProviderName = findViewById(R.id.et_pTitle);
        editTextProviderEmail = findViewById(R.id.et_pTitle);
        editTextProviderPhone = findViewById(R.id.et_pPhoneNumber);
        editTextProviderLocation = findViewById(R.id.et_pLocCor);
    }

    public void saveProduct() {
        final String inputProviderName = editTextProviderName.getText().toString().trim();
        final String inputProviderEmail = editTextProviderEmail.getText().toString().trim();
        final String inputProviderPhone = editTextProviderPhone.getText().toString().trim();
        final String inputProviderLocation = editTextProviderLocation.getText().toString().trim();


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
    }
    class SaveProvider extends AsyncTask<Void, Void, Void> {

        private String inputProviderName;
        private String inputProviderEmail;
        private String inputProviderPhone;
        private String inputProviderLocation;

        @Override
        protected Void doInBackground(Void... voids) {

            //creating a provider
            Providers providers = new Providers();

            providers.setName(inputProviderName);
            providers.setProvidersEmailAddress(inputProviderEmail);
            providers.setProviderPhoneNumber(inputProviderPhone);
            providers.setLocationCoordinates(inputProviderLocation);


            //adding to database
            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .providersDao()
                    .insert(providers);
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

//    SaveProvider st = new SaveProvider();
//        st.execute();
}



