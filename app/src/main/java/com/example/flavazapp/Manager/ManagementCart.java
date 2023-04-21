package com.example.flavazapp.Manager;


import android.content.Context;
import android.widget.Toast;

import com.example.flavazapp.Domain.FoodDomain;
import com.example.flavazapp.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private static Context context;
    private static Manager Manager;

    public ManagementCart(Context context) {
        this.context = context;
        this.Manager = new Manager(context);
    }

    public static void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }

        Manager.putListObject("CartList", listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();

    }

    public static ArrayList<FoodDomain> getListCart() {
        return Manager.getListObject("CartList");
    }

    //Add quantity to number of item
    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position,
                               ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() + 1);
        Manager.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }
    //Remove quantity to number of item
    public void MinusNumberFood(ArrayList<FoodDomain> listfood, int position,
                                ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
         Manager.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }
    //Total fee on checkOut
    public Double getTotalFee() {
        ArrayList<FoodDomain> listFood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listFood2.size(); i++) {
            fee = fee + (listFood2.get(i).getFee() * listFood2.get(i).getNumberInCart());
        }
        return fee;
    }

}
