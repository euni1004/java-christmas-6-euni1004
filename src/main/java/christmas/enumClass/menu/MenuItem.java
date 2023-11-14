package christmas.enumClass.menu;

import christmas.exception.CustomException;
import christmas.exception.ErrorCode;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6000, MenuCategory.APPETIZER),
    TAPAS("타파스", 5500, MenuCategory.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuCategory.APPETIZER),

    T_BONE_STEAK("티본스테이크", 55000, MenuCategory.MAIN),
    BARBECUE_RIB("바비큐립", 54000, MenuCategory.MAIN),
    SEAFOOD_SPAGHETTI("해산물파스타", 35000, MenuCategory.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuCategory.MAIN),

    CHOCOLATE_CAKE("초코케이크", 15000, MenuCategory.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuCategory.DESSERT),

    ZERO_COLA("제로콜라", 3000, MenuCategory.BEVERAGE),
    RED_WINE("레드와인", 60000, MenuCategory.BEVERAGE),
    CHAMPAGNE("삼페인", 25000, MenuCategory.BEVERAGE);

    private final String name;
    private final int price;
    private final MenuCategory menuCategory;

    MenuItem(String name, int price, MenuCategory menuCategory) {
        this.name = name;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public static MenuItem fromString(String menuItem) {
        for (MenuItem menu : MenuItem.values()) {
            if (menu.getName().equals(menuItem)) {
                return menu;
            }
        }
        throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
    }

    public String getName() {
        return name;
    }

    public int sumPrice(int sum) {
        sum += this.price;
        return sum;
    }

    public int getPrice(){
        return price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
}

