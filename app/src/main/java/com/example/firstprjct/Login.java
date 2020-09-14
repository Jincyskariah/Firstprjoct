package com.example.firstprjct;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText phone,password;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=findViewById(R.id.txtph);
        password=findViewById(R.id.txtpass);
        login=findViewById(R.id.btnlogin);
        signup=findViewById(R.id.btnsignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String logeph=phone.getText().toString();
                Log.e("loginph",logeph);
                String lognpass=password.getText().toString();
                Log.e("loginpass",lognpass);

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
                String regph=sharedPreferences.getString("regphno",null);
                Log.e("phreg",regph);
                String regpass=sharedPreferences.getString("regpass",null);
                Log.e("passreg",regpass);

                if (logeph.equals(regph) && lognpass.equals(regpass))
                {
                    Intent intent=new Intent(Login.this,Profile.class);
                    startActivity(intent);
                    Toast.makeText(Login.this, "Sucessfully completed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this, "plz enter the correct details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
