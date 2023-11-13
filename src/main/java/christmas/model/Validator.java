package christmas.model;

import christmas.domain.Menu;
import christmas.exception.CustomException;
import christmas.exception.ErrorCode;
import java.util.List;

public class Validator {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int MAX_MENU = 20;

    public int isNumeric(String input) {
        try {
            return new InputService().changeStringToInt(input);
        } catch (IllegalArgumentException e) {
            throw new CustomException(ErrorCode.INPUT_TYPE_ERROR);
        }
    }

    public void isValidDay(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new CustomException(ErrorCode.DAY_INPUT_ERROR);
        }
    }

    public void isValidMenuFormat(String input) {
        if (!input.matches("^[\\w가-힣]+-\\d+(,[\\w가-힣]+-\\d+)*$")) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    public void isValidMenu(String[] parts) {
        if (parts.length != 2 || !parts[1].matches("\\d+") || Integer.parseInt(parts[1]) < 1) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    public void isValidMenuSum(int sum) {
        if (sum > MAX_MENU) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    public void isValidOnlyBeverage(int a, int b){
        if(a==b){
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }
}
