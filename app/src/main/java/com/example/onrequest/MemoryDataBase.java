package com.example.onrequest;

import java.util.ArrayList;
import java.util.List;

public class MemoryDataBase {

    private static List<Menu> menuList;

    private static List<Menu> initializeList() {
        if (menuList == null) {
            menuList = new ArrayList<>();
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuList.add(new Menu("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
        }
        return menuList;
    }

    public static List<Menu> getAllMenus() {return initializeList();}


    public static Menu getAllMenus(int position) {
        return initializeList().get(position);
    }
}
