package com.example.firstprjct;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Register extends AppCompatActivity {
    EditText name,email,dob,Age,pass,phno;
    Button signup;

    @TargetApi(VERSION_CODES.N)
    @RequiresApi(api = VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.txtname);
        email=findViewById(R.id.txtmail);
        dob=findViewById(R.id.txtdob);
        Age=findViewById(R.id.txtage);
        pass=findViewById(R.id.textpass);
        phno=findViewById(R.id.textph);
        signup=findViewById(R.id.btnreg);

        //String inputname=name.getText().toString();
        //String inputmail=email.getText().toString();
        //String inputdob=dob.getText().toString();
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DATE);


        dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {


                if(b)
                {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this);
                    datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {

                            Calendar dobc = Calendar.getInstance();
                            dobc.set(dayofmonth, (monthofyear + 1), year);

                            dob.setText (dayofmonth + "-" + (monthofyear + 1) + "-" + year);

                            int currentyear=Calendar.getInstance().get(Calendar.YEAR);
                            int age = currentyear-year;
                            Age.setText(String.valueOf(age));

                        }
                    });
                    datePickerDialog.show();

                }



            }
        });





       signup.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = VERSION_CODES.N)
           @Override
           public void onClick(View view) {
               String inputname=name.getText().toString();
               String inputmail=email.getText().toString();
               String inputdob=dob.getText().toString();



               String inputage=Age.getText().toString();
               String inputpass=pass.getText().toString();
               String inputph=phno.getText().toString();

               if(inputname.equals("") || inputmail.equals("") || inputdob.equals("") || inputage.equals("") || inputpass.equals("") || inputph.equals(""))
               {
                   Toast.makeText(Register.this, "enter all fields", Toast.LENGTH_SHORT).show();
               }
               else {


                   SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
                   SharedPreferences.Editor editor = sharedPreferences.edit();
                   editor.putString("regname", inputname);
                   editor.putString("regmail", inputmail);
                   editor.putString("regdob", inputdob);

                   editor.putString("regage", inputage);

                   editor.putString("regpass", inputpass);
                   editor.putString("regphno", inputph);
                   editor.apply();

               }
                   Intent intent = new Intent(Register.this, Login.class);
                   startActivity(intent);


           }
       });


    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//
//        menu.add();
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        return super.onContextItemSelected(item);
    }

