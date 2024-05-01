package com.example.planyourdishes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {
    RadioButton buttonMale, buttonFemale;
    Button btnCalc;
    TextView txtBmi, txtStatus, txtCalorie;
    EditText txtAge, txtHeight, txtWeight;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.calculation){
            Intent intent=new Intent(this, Calculator.class);
            startActivity(intent);
            Toast.makeText(this, "Calculation", Toast.LENGTH_LONG).show();
        } else if (item.getItemId()==R.id.total_calorie) {
            Intent intent=new Intent(this, TotalCalorie.class);
            startActivity(intent);
            Toast.makeText(this, "Total Calories", Toast.LENGTH_LONG).show();
        } else if (item.getItemId()==R.id.food_recipe) {
            Intent intent=new Intent(this, RecipeActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Food Recipes", Toast.LENGTH_LONG).show();
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        buttonMale=findViewById(R.id.radioMale);
        buttonFemale=findViewById(R.id.radioFemale);
        btnCalc=findViewById(R.id.btnCalc);
        txtBmi=findViewById(R.id.txtBmi);
        txtCalorie=findViewById(R.id.txtCalorie);
        txtAge=findViewById(R.id.txtAge);
        txtHeight=findViewById(R.id.txtHeight);
        txtWeight=findViewById(R.id.txtWeight);
        txtCalorie=findViewById(R.id.txtCalorie);
        txtStatus=findViewById(R.id.txtStatus);
        myButtonListenerMethod();

    }
    public void myButtonListenerMethod() {
        btnCalc.setOnClickListener(v -> {

            String heightStr = txtHeight.getText().toString();
            double height = Double.parseDouble(heightStr);
            double heightM = height/100;

            String weightStr = txtWeight.getText().toString();
            double weight = Double.parseDouble(weightStr);
            double BMI = (weight) / (heightM * heightM);

            String ageStr=txtAge.getText().toString();
            double age=Double.parseDouble(ageStr);

            DecimalFormat df = new DecimalFormat("#.#");
            double BMI_trimmed = Double.parseDouble(df.format(BMI));

            txtBmi.setText("Your BMI: "+Double.toString(BMI_trimmed));
            String BMI_Cat;
            if (BMI < 18.5){
                BMI_Cat = "Underweight";
            }
            else if (BMI >= 18.5 && BMI < 25){
                BMI_Cat = "Healthy Weight";
            }
            else if (BMI >=25 && BMI < 30){
                BMI_Cat = "Overweight";
            } else {
                BMI_Cat = "Obesity";

            }

            txtStatus.setText("Your weight status: "+BMI_Cat);

            double idealCalForMen=66+(13.7*weight)+(5*height)-(6.8*age);
            double idealCalForWomen=655+(9.6*weight)+(1.8*height)-(4.7*age);

            if(buttonMale.isChecked()){
                double calorieMen_trimmed = Double.parseDouble(df.format(idealCalForMen));
                txtCalorie.setText("Your ideal calorie intake: "+calorieMen_trimmed+" kcal");

            }else if(buttonFemale.isChecked()){
                double calorieWomen_trimmed = Double.parseDouble(df.format(idealCalForWomen));
                txtCalorie.setText("Your ideal calorie intake: "+calorieWomen_trimmed+" kcal");


            }else {
                Toast.makeText(getApplicationContext(),"Input your numbers", Toast.LENGTH_LONG).show();
            }
        });
    }
}
