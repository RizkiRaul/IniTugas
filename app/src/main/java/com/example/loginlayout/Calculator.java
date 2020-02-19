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

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Button btn_plus;
    Button btn_minus;
    Button btn_times;
    Button btn_divide;
    Button btn_logout;
    EditText ed_num1;
    EditText ed_num2;
    TextView tv_result;
    TextView tv_username;
    static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_times = findViewById(R.id.btn_times);
        btn_divide = findViewById(R.id.btn_divide);
        btn_logout = findViewById(R.id.btn_logout);
        ed_num1 = findViewById(R.id.ed_num1);
        ed_num2 = findViewById(R.id.ed_num2);
        tv_result = findViewById(R.id.tv_result);
        tv_username = findViewById(R.id.tv_username);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_times.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(Calculator.this, ClassControl.class);
                startActivity(intent);
            }
        });

        String username;
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            username = "";

        }else{
            username = extras.getString("username");
        }

        tv_username.setText(username);

    }

    @Override
    public void onClick(View v) {

        try {

            Double A = Double.parseDouble(ed_num1.getText().toString());
            Double B = Double.parseDouble(ed_num2.getText().toString());
            Double C = 0.0;


            switch (v.getId()){
                case R.id.btn_plus:
                    C = A + B;
                    break;

                case R.id.btn_minus:
                    C = A - B;
                    break;

                case R.id.btn_times:
                    C = A * B;
                    break;

                case R.id.btn_divide:
                    C = A / B;
                    break;
            }
            tv_result.setText(C.toString());

        }catch (Exception e){
            Toast.makeText(this, "Angka Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

        }


    }
}
