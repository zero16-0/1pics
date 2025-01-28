package com.example.pics;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class myapp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myapp);

        TextView title = findViewById(R.id.textViewTitle);
         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText nameInput = findViewById(R.id.editName);
        EditText lastNameInput = findViewById(R.id.editTextLastName);
        EditText phoneInput = findViewById(R.id.editTextPhone);
        EditText emailInput = findViewById(R.id.editTextEmail);
        Button confirmButton = findViewById(R.id.buttonConfirm);

        confirmButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String phone = phoneInput.getText().toString();
            String email = emailInput.getText().toString();

            Intent intent = new Intent(myapp.this, secondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("lastName", lastName);
            intent.putExtra("phone", phone);
            intent.putExtra("email", email);
            startActivity(intent);
        });
    }
}