package christmas.service;

import christmas.exception.CustomException;
import christmas.exception.ErrorCode;

public class Validator {

    private final int MIN_DAY = 1;
    private final int MAX_DAY = 31;

    public int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new CustomException(ErrorCode.INPUT_TYPE_ERROR);
        }
    }

    public void isValidDay(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new CustomException(ErrorCode.DAY_INPUT_ERROR);
        }
    }
}
