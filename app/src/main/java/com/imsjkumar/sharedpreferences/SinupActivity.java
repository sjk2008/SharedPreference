package com.imsjkumar.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.PrimitiveIterator;

public class SinupActivity extends AppCompatActivity {
    private EditText name, pass, confirmPassword;
    private Button createUser;
    private final String EDIT_SHARED_PREFERENCE = "My_Shared_Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinup);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        confirmPassword = findViewById(R.id.confirmPass);
        createUser = findViewById(R.id.createUser);
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = pass.getText().toString();
                String confPass = confirmPassword.getText().toString();
                String username = name.getText().toString();
                if (password != null && confPass != null && password.equalsIgnoreCase(confPass)) {
                    SharedPreferences myEdit = getSharedPreferences(EDIT_SHARED_PREFERENCE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor edited = myEdit.edit();
                    edited.putString("Password", password);
                    edited.putString("UserName", username);
                    Toast.makeText(SinupActivity.this, "SinUp Successfull", Toast.LENGTH_SHORT).show();
                    edited.commit();

                    SinupActivity.this.finish();
                }
            }
        });
    }
}