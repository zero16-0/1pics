package com.example.yourapp;

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
        setContentView(layout.activity_main);

        // تهيئة العناصر
        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etAddress = findViewById(R.id.etAddress);
        Button btnConfirm = findViewById(R.id.btnConfirm);

        // إضافة حدث النقر على الزر
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الحصول على النصوص من الحقول
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String phone = etPhone.getText().toString();
                String address = etAddress.getText().toString();

                // عرض رسالة تأكيد
                Toast.makeText(MainActivity.this, "Details Confirmed: " + name + " " + surname, Toast.LENGTH_SHORT).show();
            }
        });
    }
}