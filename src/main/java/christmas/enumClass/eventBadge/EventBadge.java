package christmas.enumClass.eventBadge;

public enum EventBadge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int minPrice;


    EventBadge(String name, int minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public int getMinPrice() {
        return minPrice;
    }
}
