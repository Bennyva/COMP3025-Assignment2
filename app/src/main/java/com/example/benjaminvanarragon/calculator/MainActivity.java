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

    public void onClick(View v){
        TextView textView = (TextView)findViewById(R.id.textView);

        int calc = 0;
        int c = arrayList.size();

        while(c!=1){

            if(arrayList.get(1).contains("+")){calc = Integer.parseInt(arrayList.get(0))+Integer.parseInt(arrayList.get(2));}
            if(arrayList.get(1).contains("-")){calc = Integer.parseInt(arrayList.get(0))-Integer.parseInt(arrayList.get(2));}
            if(arrayList.get(1).contains("*")){calc = Integer.parseInt(arrayList.get(0))*Integer.parseInt(arrayList.get(2));}
            if(arrayList.get(1).contains("/")){calc = Integer.parseInt(arrayList.get(0))/Integer.parseInt(arrayList.get(2));}

            textView.setText(Integer.toString(calc));



        }
    }

    public void clear(View v){
        TextView textView = (TextView)findViewById(R.id.textView);

            string1 = "";
            string = "";
            textView.setText("0");
            arrayList.clear();
        }
    }







