package christmas.model;

import christmas.domain.Menu;
import christmas.enumClass.menu.MenuItem;
import christmas.exception.CustomException;
import christmas.exception.ErrorCode;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int MAX_MENU = 20;

    private static final Pattern MENU_PATTERN = Pattern.compile("^[\\w가-힣]+-\\d+(,[\\w가-힣]+-\\d+)*$");

    public int isValidNumeric(String input,String errorClass) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            if(errorClass.equals("controller")){
                throw new CustomException(ErrorCode.DAY_INPUT_ERROR);
            }
            throw new CustomException(ErrorCode.INPUT_TYPE_ERROR);
        }
    }

    public void isValidDay(int day) {
        if (day < MIN_DAY || day > MAX_DAY) {
            throw new CustomException(ErrorCode.DAY_INPUT_ERROR);
        }
    }

    public void isValidMenuFormat(String input) {
        if (!MENU_PATTERN.matcher(input).matches()) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    protected void isValidMenu(String[] parts) {
        if (parts.length != 2 || !parts[1].matches("\\d+") || Integer.parseInt(parts[1]) < 1) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    protected void isValidMenuSum(int sum) {
        if (sum > MAX_MENU) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    protected void isValidOnlyBeverage(long a, int b) {
        if (a == b) {
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }

    protected void isValidMenuExist(Menu validMenu , String m){
        if(validMenu.getMenuItem().equals(MenuItem.fromString(m))){
            throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
        }
    }
}
