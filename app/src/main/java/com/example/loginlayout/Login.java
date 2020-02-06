package com.example.loginlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText id_edtxt;
    EditText pass_edtxt;
    Button login_btn;
    TextView forgot_vtxt;
    Button account_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_edtxt = findViewById(R.id.id_edtxt);
        pass_edtxt= findViewById(R.id.pass_edtxt);
        login_btn = findViewById(R.id.login_btn);
        forgot_vtxt = findViewById(R.id.forgot_vtxt);
        account_btn = findViewById(R.id.account_btn);





    }
}
