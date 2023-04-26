package com.example.onrequest;

import java.util.ArrayList;
import java.util.List;

public class MemoryDataBase {

    private static List<Menu> menuList;

    private static List<Menu> initializeList() {
        if (menuList == null) {
            menuList = new ArrayList<>();
            menuList.add(new Menu("Big Mac", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("CBO", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("Maestro", "hdhdhdh", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("Cheeseburger", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("MC Bifana", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("MC Chicken", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("MC Royall Bacon", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
            menuList.add(new Menu("Chicken Bacon", "12345678", "https://www.w3schools.com/howto/img_avatar.png\"));"));
        }
        return menuList;
    }

    public static List<Menu> getAllMenus() {
        return initializeList().get(position);
    }
}
