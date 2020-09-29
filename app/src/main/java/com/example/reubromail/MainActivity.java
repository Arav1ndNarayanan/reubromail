package com.example.reubromail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String message,email, subject;
    EditText mailEditText;
    Button mailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = ""; // plese enter a mail id
        subject = "subject...";
        mailEditText = findViewById(R.id.editText);
        mailButton = findViewById(R.id.button);

        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
            }
        });
    }

    private void senEmail() {
        message = mailEditText.getText().toString();


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, email, subject, message);

        javaMailAPI.execute();
    }
}