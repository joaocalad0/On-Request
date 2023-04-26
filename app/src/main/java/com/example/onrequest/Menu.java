package com.example.onrequest;

public class Menu {

    private final String drink;
    private final String food;
    private final String avatar;

    public Menu(String drink, String food, String avatar) {
        this.drink = drink;
        this.food = food;
        this.avatar = avatar;
    }

    public String getDrink() {
        return drink;
    }

    public String getFood() {
        return food;
    }

    public String getAvatar() {return avatar;}
}
