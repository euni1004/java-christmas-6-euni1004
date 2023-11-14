package christmas.model;

import christmas.domain.Menu;
import christmas.enumClass.eventBadge.EventBadge;
import christmas.enumClass.menu.MenuCategory;
import christmas.enumClass.menu.MenuItem;
import christmas.enumClass.week.DayOdTheWeek;
import christmas.enumClass.week.Weekdays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculateDiscountService {

    private static final int MIN_GIFTPRIZE = 120000;
    private static final int DISCOUNTFORWEEK = 2023;

    private final Menu GIFTMENU = new Menu(MenuItem.CHAMPAGNE, 1);
    private final String NOEXIST = "없음";

    private final List<Integer> SPECIALDAY = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));


    private final List<Menu> menu;
    private final int day;

    public CalculateDiscountService(List<Menu> menu, int day) {
        this.menu = menu;
        this.day = day;
    }

    public int calculateTotalOrderAmountBeforeDiscount() {
        return menu.stream()
            .mapToInt(Menu::multiply)
            .sum();
    }

    public String calculateGiftMenu(int totalBeforeDiscount) {
        if (totalBeforeDiscount >= MIN_GIFTPRIZE) {
            return GIFTMENU.toString();
        }
        return NOEXIST;
    }

    public Map<String, Integer> calculateDiscountForDay() {
        if (day > 25) {
            return Map.of("크리스마스 디데이 할인", 0);
        }
        int discount = 1000 + ((day - 1) * 100);
        return Map.of("크리스마스 디데이 할인", discount);
    }

    public Map<String, Integer> calculateDiscountForWeek() {
        int remind = day % 7;
        Weekdays weekdays = DayOdTheWeek.calculateWeekdays(remind);

        String key = Weekdays.WEEKEND.getWeekdays();
        int value = calculateCategorySum(MenuCategory.MAIN);

        if (weekdays.equals(Weekdays.WEEKDAY)) {
            key = Weekdays.WEEKDAY.getWeekdays();
            value = calculateCategorySum(MenuCategory.DESSERT);
        }

        return Map.of(key, value);
    }

    private int calculateCategorySum(MenuCategory menuCategory) {
        return menu.stream()
            .filter(m -> m.getMenuItem().getMenuCategory().equals(menuCategory))
            .mapToInt(m -> m.sumMenu(0))
            .sum() * DISCOUNTFORWEEK;
    }

    public Map<String, Integer> calculateDiscountForSpecialDay() {
        if (SPECIALDAY.contains(day)) {
            return Map.of("특별 할인", 1000);
        }
        return Map.of("특별 할인", 0);
    }

    public Map<String, Integer> calculateDiscountForGift(int totalBeforeDiscount) {
        if (totalBeforeDiscount >= MIN_GIFTPRIZE) {
            return Map.of("증정 이벤트", MenuItem.CHAMPAGNE.getPrice());
        }
        return Map.of("증정 이벤트", 0);
    }

    public int calculateTotalDiscount(Map<String, Integer> benefitDetail) {
        return benefitDetail.values().stream()
            .mapToInt(prise -> prise)
            .sum();
    }

    public int calculateDiscountTotalAmount(int totalAmountBeforeDiscount, int discountAmount) {
        if (totalAmountBeforeDiscount >= MIN_GIFTPRIZE) {
            return totalAmountBeforeDiscount - discountAmount + GIFTMENU.getMenuItem().getPrice();
        }
        return totalAmountBeforeDiscount - discountAmount;
    }

    public String calculateEventBadge(int discountAmount) {
        String eventBadge = EventBadge.calculateBadge(discountAmount);
        if (eventBadge != null) {
            return eventBadge;
        }
        return NOEXIST;
    }
}
