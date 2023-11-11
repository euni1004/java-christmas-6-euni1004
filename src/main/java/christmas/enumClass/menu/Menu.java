package christmas.enumClass.menu;

public enum Menu {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
