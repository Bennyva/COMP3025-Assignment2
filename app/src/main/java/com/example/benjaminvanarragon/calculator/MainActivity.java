package com.example.benjaminvanarragon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    float result;
    float currentNum;
    String currentNumString;
    String currentOp;
    String labelString;
    float storedNum;
    String currentOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variables for current number, results, current operation, and labels

        TextView textView = (TextView) findViewById(R.id.textView);
        result = 0;
        currentNum = 0;
        currentNumString = "";
        currentOp = "";
        labelString = "";
        storedNum = 0;
        currentOperation = "";

        currentOp = "=";
        textView.setText(String.valueOf(result));
    }



    //This method fires when a number is pressed, it sets the current number to whatever the user is sending through this method. Then procedes to set the label to the current number.
    public void btnNumberInput(View v) {
        //sets the current number to what is sent
        //currentNum = currentNum * 10 + Float(sender.currentTitle!)!
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) v;
        labelString = textView.getText().toString();


        if(labelString == "0.0"){
            currentNumString = button.getText().toString();
        }
        else{
            currentNumString = currentNumString + button.getText().toString();
        }
        currentNum = Float.valueOf(currentNumString);
        System.out.println("\ncurrent num: " + currentNum);
        System.out.println("\nStored Num: " + result);
        System.out.println("\nResult: " + result);
        //sets the result label to the current number
        textView.setText(String.valueOf(currentNum));
    }


    //This method fires when an operation button is pressed. Each case will fire when the appropriate sign is clicked. Then sets the result label to the result.
    public void btnOperation(View v) {

        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) v;
        //sets the current Operation to what is clicked
        currentOp = button.getText().toString();
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
                break;

            case "+":
                //sets the current operation for the math function
                currentOperation = "+";
                //sets a stored num, so the second num memery space is clear
                storedNum = currentNum;
                //rests the currentNum so a new value can be placed in the memory space
                currentNumString = "0";
                currentNum = 0;
                break;

            case "-":
                currentOperation = "-";
                storedNum = currentNum;
                currentNumString = "0";
                currentNum = 0;
                break;

            case "*":
                currentOperation = "*";
                storedNum = currentNum;
                currentNumString = "0";
                currentNum = 0;
                break;

            case "/":
                currentOperation = "/";
                storedNum = currentNum;
                currentNumString = "0";
                currentNum = 0;
                break;


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
        currentOp = button.getText().toString();
    }


    //resets all variables to initial values, and clears the label
    public void btnClear(View v) {

        TextView textView = (TextView) findViewById(R.id.textView);
        result = 0;
        currentNum = 0;
        currentOp = "=";
        textView.setText(String.valueOf(result));
        currentNumString = "0";

    }
}








