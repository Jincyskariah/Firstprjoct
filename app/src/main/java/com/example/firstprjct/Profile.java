package com.example.firstprjct;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    TextView name,email,dob,age,pass,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.textname);
        email=findViewById(R.id.textmail);
        dob=findViewById(R.id.textdob);
        age=findViewById(R.id.textage);
        pass=findViewById(R.id.textpassword);
        phone=findViewById(R.id.textphone);


        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        String proname=sharedPreferences.getString("regname",null);
        String proemail=sharedPreferences.getString("regmail",null);
        String prodob=sharedPreferences.getString("regdob",null);
        String proage=sharedPreferences.getString("regage",null);
        String propass=sharedPreferences.getString("regpass",null);
        String proph=sharedPreferences.getString("regphno",null);
        name.setText(proname);
        email.setText(proemail);
        dob.setText(prodob);
        age.setText(proage);
        pass.setText(propass);
        phone.setText(proph);
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
      AlertDialog.Builder builder=new AlertDialog.Builder(Profile.this);

        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
                Toast.makeText(Profile.this, "choose yes action for alertbox", Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Profile.this, "choose no action for alertbox", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alert=builder.create();
        alert.setTitle("Alert Dialog box");
        alert.show();

    }
}
