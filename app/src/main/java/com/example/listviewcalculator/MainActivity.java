package com.example.listviewcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbhe, rbha;
    EditText etfirst, etdm;
    int type=500;
    Double first, dom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbhe= (RadioButton) findViewById(R.id.rbhe);
        rbha= (RadioButton) findViewById(R.id.rbha);
        etfirst=(EditText) findViewById(R.id.etfirst);
        etdm=(EditText) findViewById(R.id.etdm);
    }


    public void go2 (View v){
        if ((etfirst.getText().toString().equals(""))||(etfirst.getText().toString().equals(".-"))||((etfirst.getText().toString().equals("."))||(etfirst.getText().toString().equals("-"))||(etfirst.getText().toString().equals("-.")))||
                ((etdm.getText().toString().equals("")) ||(etdm.getText().toString().equals(".-"))||((etdm.getText().toString().equals("."))||(etdm.getText().toString().equals("-"))||(etdm.getText().toString().equals("-."))))){
            Toast.makeText(this, "Input is unavailable", Toast.LENGTH_SHORT).show();
        }
        else {
            String st = etfirst.getText().toString();
            first=Double.parseDouble(st);
            String st2 = etdm.getText().toString();
            dom=Double.parseDouble(st2);

            if ((!rbhe.isChecked())&&(!rbha.isChecked()))
                Toast.makeText(this, "You need to finish in order to continue", Toast.LENGTH_LONG).show();
            else{
                if(rbhe.isChecked())
                    type = 1;
                else {
                    type = 0;
                }
            }
            Intent t = new Intent(this, SecActivity.class);
            t.putExtra("first", first);
            t.putExtra("type", type);
            t.putExtra("dom", dom);
            startActivity(t);
        }
    }

    public void gocreds(View view) {
        Intent t=new Intent(this, CreditsActivity.class);
        startActivity(t);
    }
}