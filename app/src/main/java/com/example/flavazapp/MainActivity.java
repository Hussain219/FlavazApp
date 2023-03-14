package com.example.flavazapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flavazapp.Adapter.CategoryAdapter;
import com.example.flavazapp.Adapter.PopularAdapter;
import com.example.flavazapp.Domain.CategoryDomain;
import com.example.flavazapp.Domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerViewCategory();
         recyclerViewPopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Wraps", "cat_3"));
        category.add(new CategoryDomain("Drink", "cat_4"));
        category.add(new CategoryDomain("Doughnut", "cat_5"));

        adapter=new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularlist=findViewById(R.id.recyclerView2);

        ArrayList<FoodDomain> foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","pizza1","Slices Pepperoni, Mozzerella Cheese, Ground Black Peppers, Pizza Sauce", 7.99));
        foodList.add(new FoodDomain("Cheese Burger", "burger","Beef, Cheese Slice, Burger Sauce, Lettuce, Tomatoes",5.99));
        foodList.add(new FoodDomain("Vegetable Pizza", "pizza2","Olive Oil, Vegetable Oil, Onions, SweetCorn, Peppers, Mudshrooms",6.99));

        adapter2=new PopularAdapter(foodList);
        recyclerViewPopularlist.setAdapter(adapter2);


    }

}