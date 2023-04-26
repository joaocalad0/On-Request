package com.example.onrequest;

public class Menu {

    private final String drink;
    private final String food;

    public Menu(String drink, String food) {
        this.drink = drink;
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public String getFood() {
        return food;
    }
}
