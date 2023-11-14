package christmas.enumClass.week;

public enum DayOdTheWeek {

    FRIDAY(Weekdays.WEEKEND),
    SATURDAY(Weekdays.WEEKEND),

    SUNDAY(Weekdays.WEEKDAY),
    MONDAY(Weekdays.WEEKDAY),
    TUESDAY(Weekdays.WEEKDAY),
    WEDNESDAY(Weekdays.WEEKDAY),
    THURSDAY(Weekdays.WEEKDAY);
    private final Weekdays weekdays;

    DayOdTheWeek(Weekdays weekdays) {
        this.weekdays = weekdays;
    }

    public static Weekdays calculateWeekdays(int remind){
        return DayOdTheWeek.values()[remind].weekdays;
    }
}
