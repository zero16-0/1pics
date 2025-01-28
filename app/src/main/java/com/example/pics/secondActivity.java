package com.example.pics;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class secondActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private ImageView profileImage;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        TextView profileTitle = findViewById(R.id.imageViewProfile);
        TextView nameText = findViewById(R.id.textViewName);
        TextView lastNameText = findViewById(R.id.textViewLastName);
        TextView phoneText = findViewById(R.id.textViewPhone);
        TextView emailText = findViewById(R.id.textViewEmail);
        profileImage = findViewById(R.id.textViewName);
        Button goBackButton = findViewById(R.id.buttonGoBack);
        Button changePictureButton = findViewById(R.id.buttonChangePicture);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String lastName = intent.getStringExtra("lastName");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");

        nameText.setText("First Name: " + name);
        lastNameText.setText("Last Name: " + lastName);
        phoneText.setText("Phone: " + phone);
        emailText.setText("Email: " + email);

        goBackButton.setOnClickListener(v -> finish());

        changePictureButton.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
            } else {
                openCamera();
            }
        });
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                profileImage.setImageBitmap((android.graphics.Bitmap) extras.get("data"));
            }
        }
    }
}
