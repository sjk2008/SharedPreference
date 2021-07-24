package com.imsjkumar.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name, password;
    private Button login, sinup;
    private final String EDIT_SHARED_PREFERENCE = "My_Shared_Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.firstName);
        password = findViewById(R.id.password);
        sinup = findViewById(R.id.sinUp);
        login = findViewById(R.id.login);

        sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SinupActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences myEdit = getSharedPreferences(EDIT_SHARED_PREFERENCE , Context.MODE_PRIVATE);
                String strname = myEdit.getString("UserName",null);
                String strpassword = myEdit.getString("Password",null);

                String userName = name.getText().toString();
                String stpassword = password.getText().toString();
                if (strname != null && userName != null && strname.equalsIgnoreCase(userName)){
                    if (stpassword != null && stpassword!=null && strpassword.equalsIgnoreCase(stpassword)){
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}