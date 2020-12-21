package com.example.kidzcashfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.UUID;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText creditCard;
    private EditText cvv;
    private EditText date;
    private TextView emailError;
    private TextView passwordError;
    private Button regBtn;
    private Button scan;

    private UUID uuid;
    public static Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regBtn = findViewById(R.id.register);
        regBtn.setOnClickListener(this);
        scan = findViewById(R.id.scan);
        scan.setOnClickListener(this);
        emailError = findViewById(R.id.emailErrorReg);
        passwordError = findViewById(R.id.passwordErrorReg);

    }


    @Override
    public void onClick(View v) {
        // when clicked register
        if (v.getId() == R.id.register) {
            name = findViewById(R.id.name);
            email = findViewById(R.id.emailReg);
            password = findViewById(R.id.passwordReg);
            creditCard = findViewById(R.id.creditCard);
            cvv = findViewById(R.id.cvv);
            date = findViewById(R.id.exDate);

            if (!HelpClass.checkEmail(email.getText().toString())) {
                emailError.setText("המייל שהוזן לא תקין");
            } else if (!HelpClass.checkPassword(password.getText().toString())) {
                passwordError.setText("הסיסמא לא עומדת במדיניות הסיסמאות");
            } else {
                this.uuid = UUID.randomUUID();
                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    client = new Client();
                    client.Add(uuid, name.getText().toString(), email.getText().toString(), password.getText().toString(), creditCard.getText().toString(), cvv.getText().toString(), date.getText().toString());
                    startActivity(new Intent(MainActivity.this, horim.class).putExtra("uuid", uuid));
                } catch (Exception e) {
                    emailError.setText(e.toString());
                }
            }
        }
        else if(v.getId() == R.id.scan){
            startActivity(new Intent(MainActivity.this, Scan.class));
        }
    }
}


