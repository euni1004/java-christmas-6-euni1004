package christmas.enumClass.week;

public enum Weekdays {

    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인");

    private final String weekdays;

    Weekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public String getWeekdays() {
        return weekdays;
    }
}
