/*package com.example.kidzcashfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Log_in extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private EditText password;
    private TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    // validate and check if the data is exist in the DB
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
            error = findViewById(R.id.error);
            if(MainActivity.client.Verify(email.getText().toString(), password.getText().toString())){
                //Redirect to main page
            }
            else{
                error.setText("Not Verified");
            }
        }
    }
}*/
