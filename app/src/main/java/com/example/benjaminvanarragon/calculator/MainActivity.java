package com.example.benjaminvanarragon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variables for current number, results, current operation, and labels
    TextView textView = (TextView) findViewById(R.id.textView);
    float result = 0;
    float currentNum = 0;
    String currentNumString = "";
    String currentOp = "";
    String labelString = "";
    float storedNum = 0;
    String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentOp = "=";
        textView.setText(String.valueOf(result));
    }

    //This method fires when a number is pressed, it sets the current number to whatever the user is sending through this method. Then procedes to set the label to the current number.
    public void btnNumberInput(View v) {
        //sets the current number to what is sent
        //currentNum = currentNum * 10 + Float(sender.currentTitle!)!

        labelString = textView.getText().toString();


        if(labelString == "0"){
            currentNumString = v.toString();
        }
        else{
            currentNumString = currentNumString + v.toString();
        }
        currentNum = Float.parseFloat(currentNumString);
        System.out.println("\ncurrent num: " + currentNum);
        System.out.println("\nStored Num: " + result);
        System.out.println("\nResult: " + result);
        //sets the result label to the current number
        textView.setText(String.valueOf(currentNum));
    }


    //This method fires when an operation button is pressed. Each case will fire when the appropriate sign is clicked. Then sets the result label to the result.
    public void btnOperation(View v) {

        //sets the current Operation to what is clicked
        currentOp = v.toString();
        switch (currentOp){
            //all the math is done here
            case "=":
                //if statements to check what the current operation was for the equation
                if(currentOperation == "+"){
                    //sets the result to num1 + num2
                    result = storedNum + currentNum;
                    //sets the currentNum to the result in case the user wants to append math functions on the equation
                    currentNum = result;
                }
                else if(currentOperation == "-"){
                    result = storedNum - currentNum;
                    currentNum = result;
                }
                else if(currentOperation == "*"){
                    result = storedNum * currentNum;
                    currentNum = result;
                }
                else if(currentOperation == "/"){
                    result = storedNum / currentNum;
                    currentNum = result;
                }else{
                    System.out.println("error");
                    textView.setText("err");
                }

            case "+":
                //sets the current operation for the math function
                currentOperation = "+";
                //sets a stored num, so the second num memery space is clear
                storedNum = currentNum;
                //rests the currentNum so a new value can be placed in the memory space
                currentNumString = "0";
                currentNum = 0;

            case "-":
                currentOperation = "-";
                storedNum = currentNum;
                currentNumString = "0";
                currentNum = 0;

            case "*":
                currentOperation = "*";
                storedNum = currentNum;
                currentNumString = "0";
                currentNum = 0;

            case "/":
                currentOperation = "/";
                storedNum = currentNum;
                currentNumString = "0";
                currentNum = 0;


                //default switch case if none are available.
            default:
                System.out.println("error");
        }

        //currentNumString = "0"
        //currentNum = 0
        textView.setText(String.valueOf(result));

        //if(sender.titleLabel!.text == "="){
        //    result = 0
        //}
        //sets the current operation to what is sent through the method
        currentOp = v.toString();
    }


    //resets all variables to initial values, and clears the label
    public void btnClear(View v) {
        result = 0;
        currentNum = 0;
        currentOp = "=";
        textView.setText(String.valueOf(result));
        currentNumString = "0";

    }
}








