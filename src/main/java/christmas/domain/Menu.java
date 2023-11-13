package christmas.domain;

import christmas.enumClass.menu.MenuItem;

public class Menu {

    private final MenuItem menuItem;
    private final int menuCount;

    public Menu(MenuItem menuItem, int menuCount){
        this.menuItem = menuItem;
        this.menuCount = menuCount;
    }

    public MenuItem getMenuItem(){
        return menuItem;
    }

    public int getMenuCount(){
        return menuCount;
    }

    @Override
    public String toString(){
        return menuItem.getName()+" "+menuCount+"개";
    }

}
