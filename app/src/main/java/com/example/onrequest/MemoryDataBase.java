package com.example.onrequest;

import java.util.ArrayList;
import java.util.List;

public class MemoryDataBase {

    private static List<MenuEntraces> menuEntracesList;

    private static List<MenuEntraces> initializeList() {
        if (menuEntracesList == null) {
            menuEntracesList = new ArrayList<>();
            menuEntracesList.add(new MenuEntraces(1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(2, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(2, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(4, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(5, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(6, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(7, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(8, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(9, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(10, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(11, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(12, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(13, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(15, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces(16, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png"));
        }
        return menuEntracesList;
    }

    public static List<MenuEntraces> getAllMenus() {return initializeList();}


    public static MenuEntraces getAllMenus(int position) {
        return initializeList().get(position);
    }
}
