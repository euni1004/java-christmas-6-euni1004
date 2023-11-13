package christmas.model;

import christmas.domain.Menu;
import christmas.enumClass.menu.MenuCategory;
import christmas.enumClass.menu.MenuItem;
import christmas.exception.CustomException;
import christmas.exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputService {

    Validator validator = new Validator();

    public int changeStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public String[] splitMenuToComma(String input) {
        return input.split(",");
    }

    public String[] splitMenuToBar(String tempMenu) {
        return tempMenu.split("-");
    }

    public List<Menu> validMenu(String input) {
        String[] tempMenu = splitMenuToComma(input);
        List<Menu> menu = new ArrayList<>();

        for (String temp : tempMenu) {
            String[] part = splitMenuToBar(temp);
            validator.isValidMenu(part);
            validateMenuDoesNotExist(menu, part[0]);
            menu.add(new Menu(MenuItem.fromString(part[0]), validator.isNumeric(part[1])));
        }
        return menu;
    }

    public void validateMenuDoesNotExist(List<Menu> menus, String menu) {
        for (Menu m : menus) {
            if (m.getMenuItem().equals(MenuItem.fromString(menu))) {
                throw new CustomException(ErrorCode.MENU_INPUT_ERROR);
            }
        }
    }

    public void isValidMenuSum(List<Menu> menus) {
        int sum = 0;
        for (Menu m : menus) {
            sum += m.getMenuCount();
        }
        validator.isValidMenuSum(sum);
    }

    public void validateMenuByBeverage(List<Menu> menus) {
        List<Menu> temp = new ArrayList<>();
        for (Menu m : menus) {
            if (m.getMenuItem().getMenu().equals(MenuCategory.BEVERAGE)) {
                temp.add(m);
            }
        }
        validator.isValidOnlyBeverage(temp.size(),menus.size());
    }


}
