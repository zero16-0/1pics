package com.example.pics;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity; 

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etAddress = findViewById(R.id.etAddress);
        Button btnConfirm = findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String surname = etSurname.getText().toString();
            String phone = etPhone.getText().toString();
            String address = etAddress.getText().toString();

            Toast.makeText(MainActivity.this,
                    "Details Confirmed: " + name + " " + surname +
                            ", Phone: " + phone + ", Address: " + address,
                    Toast.LENGTH_SHORT).show();
        });
    }
}