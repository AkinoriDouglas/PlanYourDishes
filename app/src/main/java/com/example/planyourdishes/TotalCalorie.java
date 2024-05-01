package com.example.planyourdishes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class TotalCalorie extends AppCompatActivity {

    CheckBox checkChickenSalad, checkSalmonBowl,checkBolognese,checkVegetableUdon,
            checkBeefChowMein, checkChickenParmesan, checkLentilTunaSalad, checkSalmonPasta;
    Button btnTotal;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_calorie);
        addListenerOnButtonClick();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public void addListenerOnButtonClick(){
        checkChickenSalad=findViewById(R.id.checkChickenSalad);
        checkSalmonBowl=findViewById(R.id.checkSalmonBowl);
        checkBolognese=findViewById(R.id.checkBolognese);
        checkVegetableUdon=findViewById(R.id.checkVegetableUdon);
        checkBeefChowMein=findViewById(R.id.checkBeefChowMein);
        checkChickenParmesan=findViewById(R.id.checkChickenParmesan);
        checkLentilTunaSalad=findViewById(R.id.checkLentilTunaSalad);
        checkSalmonPasta=findViewById(R.id.checkSalmonPasta);
        btnTotal=findViewById(R.id.btnTotal);
        txtResult=findViewById(R.id.txtResult);


        btnTotal.setOnClickListener(view -> {
            int totalAmount=0;
            if(checkChickenSalad.isChecked()){
                totalAmount+=353;
            }
            if(checkSalmonBowl.isChecked()){
                totalAmount+=464;
            }
            if(checkBolognese.isChecked()){
                totalAmount+=387;
            }
            if(checkVegetableUdon.isChecked()){
                totalAmount+=366;
            }
            if(checkBeefChowMein.isChecked()){
                totalAmount+=407;
            }
            if(checkChickenParmesan.isChecked()){
                totalAmount+=327;
            }
            if(checkLentilTunaSalad.isChecked()){
                totalAmount+=374;
            }
            if(checkSalmonPasta.isChecked()){
                totalAmount+=543;
            }
            txtResult.setText("Today's calorie: "+totalAmount+" kcal");

        });
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


}