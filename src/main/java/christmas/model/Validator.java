package christmas.model;

import christmas.exception.CustomException;
import christmas.exception.ErrorCode;

public class Validator {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

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

    public void isValidMenuFormat(String input){
        if(!input.matches("^\\w+-\\d+(,\\w+-\\d+)*$")){
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    public String[] isValidMenu(String[] parts){
        if (parts.length != 2 || !parts[1].matches("\\d+") || Integer.parseInt(parts[1]) < 1) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
        return parts;
    }



}
