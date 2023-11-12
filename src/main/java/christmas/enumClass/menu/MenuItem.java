package christmas.enumClass.menu;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6000, Menu.APPETIZER),
    TAPAS("타파스", 5500, Menu.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Menu.APPETIZER),

    T_BONE_STEAK("티본스테이크", 55000, Menu.MAIN),
    BARBECUE_RIB("바비큐립", 54000, Menu.MAIN),
    SEAFOOD_SPAGHETTI("해산물파스타", 35000, Menu.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Menu.MAIN),

    CHOCOLATE_CAKE("초코케이크", 15000, Menu.DESSERT),
    ICE_CREAM("아이스크림", 5000, Menu.DESSERT),

    ZERO_COLA("제로콜라", 3000, Menu.BEVERAGE),
    RED_WINE("레드와인", 60000, Menu.BEVERAGE),
    CHAMPAGNE("삼페인", 25000, Menu.BEVERAGE);

    private final String name;
    private final int price;
    private final Menu menu;

    MenuItem(String name, int price, Menu menu) {
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Menu getMenu() {
        return menu;
    }
}

