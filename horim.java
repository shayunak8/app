package com.example.kidzcashfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class horim extends AppCompatActivity implements View.OnClickListener {
    private TextView nameView;
    private EditText amount;
    private Button charge;
    private Client client;
    private String uuid;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horim);
        Intent intent = getIntent();
        uuid = intent.getExtras().getString("uuid");
        client = MainActivity.client;
        nameView = findViewById(R.id.name2);
        nameView.setText(client.getName(uuid)+"ברוך שובך ");
        amount = findViewById(R.id.amount);
        charge= findViewById(R.id.charge);
        charge.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.charge){
            if(amount.getText().toString() != ""){
                client.Charge(uuid,amount.getText().toString());
            }
        }
    }
}
