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

    public static String calculateBadge(int discountAmount) {
        if (discountAmount >= SANTA.minPrice) {
            return SANTA.name;
        }
        if (discountAmount >= TREE.minPrice) {
            return TREE.name;
        }
        if (discountAmount >= STAR.minPrice) {
            return STAR.name;
        }
        return null;
    }
}
