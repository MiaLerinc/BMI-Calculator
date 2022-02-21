package com.example.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class Controller {
    private double result;

    @FXML
    private TextField height;

    @FXML
    private TextField weight;

    @FXML
    private RadioButton IU;

    @FXML
    private RadioButton MU;

    @FXML
    private Label BMI1;

    @FXML
    private Label BMI2;

    @FXML
    private Label BMI3;

    @FXML
    private Label BMI4;

    @FXML
    private Label BMI5;

    @FXML
    private Label BMI6;

    @FXML
    private Label num;

    @FXML
    protected void onCalculateButtonClick() {
        double height_=0;
        double weight_=0;


        String valueHeight = height.getText();
        String valueWeight = weight.getText();
        try
        {
            height_=Double.parseDouble(valueHeight);
        }
        catch (NumberFormatException e)
        {
            num.setText("Please enter positive number!");
            height.clear();
        }
        try
        {
            weight_=Double.parseDouble(valueWeight);

        }
        catch (NumberFormatException e)
        {
            num.setText("Please enter positive number!");
            weight.clear();
        }

        if(weight_ > 0 && height_ >0)
        {
            num.setText("");
            BMI1.setText("");
            BMI2.setText("");
            BMI3.setText("");
            BMI4.setText("");
            BMI5.setText("");
            BMI6.setText("");
            if (IU.isSelected())
            {
                result=(703*weight_)/(Math.pow(height_,2));
            }
            else if(MU.isSelected())
            {
                result=weight_/(Math.pow(height_,2));
            }
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            if(result<18.5)
            {
                BMI1.setText(numberFormat.format(result) + "\n(Underweight)");
            }
            else if(result>=18.5 && result <25)
            {
                BMI2.setText(numberFormat.format(result) + "\n(Healthy weight)");
            }
            else if(result>=25 && result <30)
            {
                BMI3.setText(numberFormat.format(result) + "\n(Overweight)");
            }
            else if(result>=30 && result <35)
            {
                BMI4.setText(numberFormat.format(result) + "\n(Obese Type I)");
            }
            else if(result>=35 && result <40)
            {
                BMI5.setText(numberFormat.format(result) + "\n(Obese Type II)");
            }
            else if(result>=40)
            {
                BMI6.setText(numberFormat.format(result) + "\n(Obese Type III)");
            }

        }
        else if(weight_ <=0 || height_ <=0)
        {
            num.setText("Please enter positive number!");
            weight.clear();
            height.clear();
        }

    }
}