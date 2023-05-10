package com.example.onrequest;

import java.util.ArrayList;
import java.util.List;

public class MemoryDataBase {

    private static List<MenuEntraces> menuEntracesList;

    private static List<MenuEntraces> initializeList() {
        if (menuEntracesList == null) {
            menuEntracesList = new ArrayList<>();
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "https://www.w3schools.com/howto/img_avatar.png");
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
            menuEntracesList.add(new MenuEntraces("Lorem Ipsum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ", "https://www.w3schools.com/howto/img_avatar.png"));
        }
        return menuEntracesList;
    }

    public static List<MenuEntraces> getAllMenus() {return initializeList();}


    public static MenuEntraces getAllMenus(int position) {
        return initializeList().get(position);
    }
}
