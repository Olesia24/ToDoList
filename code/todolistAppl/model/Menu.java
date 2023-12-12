package todolistAppl.model;

import java.io.Serializable;

public enum Menu implements Serializable {
    ADD(1, "Add Task"), VIEW(2, "View of Tasks"), REM(3,"Remove Task"), SAVE(4,"Save Tasks"),LOAD(5,"Load Tasks"), EXIT(6,"Exit");

    private int menuItem;
    private String action;

    Menu(int menuItem, String action) {
        this.menuItem = menuItem;
        this.action = action;
    }
    public static void printMenu(){
        Menu[] menu = Menu.values();//put enum items into array
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i].menuItem + " - " + menu[i].action + " | ");
        }
        System.out.println();
    }
}

