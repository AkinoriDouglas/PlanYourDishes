package com.example.planyourdishes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;



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
        setContentView(R.layout.activity_recipe);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

    }

}