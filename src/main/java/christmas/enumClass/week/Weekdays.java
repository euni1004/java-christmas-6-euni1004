package christmas.enumClass.week;

public enum Weekdays {

    WEEKDAY("평일"),
    WEEKEND("주말");

    private final String weekdays;

    Weekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public String getWeekdays() {
        return weekdays;
    }
}
