package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    private int dish_id;
    private int product_id;
    private int ingredient_amount;

    public Ingredient(){
    }

    public Ingredient(int dish_id, int product_id, int ingredient_amount){
        this.dish_id = dish_id;
        this.product_id = product_id;
        this.ingredient_amount = ingredient_amount;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getIngredient_amount() {
        return ingredient_amount;
    }

    public void setIngredient_amount(int ingredient_amount) {
        this.ingredient_amount = ingredient_amount;
    }
}
