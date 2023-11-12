package christmas.enumClass.week;

public enum DayOdTheWeek {

    SUNDAY("일요일", Weekdays.WEEKDAY),
    MONDAY("월요일", Weekdays.WEEKDAY),
    TUESDAY("화요일", Weekdays.WEEKDAY),
    WEDNESDAY("수요일", Weekdays.WEEKDAY),
    THURSDAY("목요일", Weekdays.WEEKDAY),

    FRIDAY("금요일", Weekdays.WEEKEND),
    SATURDAY("토요일", Weekdays.WEEKEND);

    private final String dayOfTheWeek;
    private final Weekdays weekdays;

    DayOdTheWeek(String dayOfTheWeek, Weekdays weekdays) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.weekdays = weekdays;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public Weekdays getWeekdays() {
        return weekdays;
    }
}
