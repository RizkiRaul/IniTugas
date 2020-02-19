package com.example.loginlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText id_edtxt;
    EditText pass_edtxt;
    Button login_btn;
    TextView forgot_vtxt;
    Button account_btn;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        pref = getSharedPreferences("login", MODE_PRIVATE);
        id_edtxt = findViewById(R.id.id_edtxt);
        pass_edtxt= findViewById(R.id.pass_edtxt);
        login_btn = findViewById(R.id.login_btn);
        forgot_vtxt = findViewById(R.id.forgot_vtxt);
        account_btn = findViewById(R.id.account_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (id_edtxt.getText().toString()!=null && pass_edtxt.getText().toString()!=null) {
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Calculator.class);
                    String strName = null;
                    intent.putExtra("username", strName);
                    editor = pref.edit();
                    editor.putString("username", id_edtxt.getText().toString());
                    editor.apply();
                    finish();
                    startActivity(intent);
                }
            }
        });



    }
}
