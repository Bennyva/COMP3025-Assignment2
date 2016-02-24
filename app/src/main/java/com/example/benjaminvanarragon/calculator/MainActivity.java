package com.example.benjaminvanarragon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ArrayList<String> arrayList = new ArrayList<String>();
    String string = "";
    String string1 = "";
    public void onClick1(View v){
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) v;

        string = (String) button.getText().toString();

        if(!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")){
            string1 = string1 + string;

            if(arrayList.size()>0){
                arrayList.remove(arrayList.size()-1);

            }
            arrayList.add(string1);

        }
        else{
            arrayList.add(string);
            arrayList.add(string);
            string1="";
        }

        //textView.setText(textView.getText().toString()+string);

        textView.setText(arrayList.toString());
    }








}
