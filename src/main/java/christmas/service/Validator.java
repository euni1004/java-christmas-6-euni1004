package christmas.service;

import christmas.exception.CustomException;
import christmas.exception.ErrorCode;

public class Validator {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    public static int isNumeric(String input) {
        try {
            return new InputService().changeStringToInt(input);
        } catch (IllegalArgumentException e) {
            throw new CustomException(ErrorCode.INPUT_TYPE_ERROR);
        }
    }

    public static void isValidDay(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new CustomException(ErrorCode.DAY_INPUT_ERROR);
        }
    }


}
