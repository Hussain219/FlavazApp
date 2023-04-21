package com.example.flavazapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.flavazapp.Domain.FoodDomain;
import com.example.flavazapp.Manager.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, foodPic;
    private FoodDomain object;
    int numberOrder = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        initView();
        getBundle();
    }




    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");


        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        drawableResourceId = R.drawable.pop_1;
        Glide.with(this)
                .load(drawableResourceId)
                .into(foodPic);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("£" + object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));

            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                ManagementCart.insertFood(object);
            }

        });
    }





    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById((R.id.titleTxt));
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        foodPic=findViewById(R.id.foodPic);
    }
}
