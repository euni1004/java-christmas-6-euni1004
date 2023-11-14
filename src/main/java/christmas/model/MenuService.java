package christmas.model;

import christmas.domain.Menu;
import christmas.enumClass.menu.MenuCategory;
import christmas.enumClass.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuService {

    Validator validator = new Validator();

    public List<Menu> createMenu(String input) {
        String[] tempMenu = splitMenuToComma(input);
        List<Menu> menu = new ArrayList<>();

        for (String temp : tempMenu) {
            String[] part = splitMenuToBar(temp);
            validator.isValidMenu(part);
            validateMenuExist(menu, part[0]);
            menu.add(new Menu(MenuItem.fromString(part[0]), validator.isValidNumeric(part[1],"service")));
        }
        return menu;
    }

    public String[] splitMenuToComma(String input) {
        return input.split(",");
    }

    public String[] splitMenuToBar(String tempMenu) {
        return tempMenu.split("-");
    }

    private void validateMenuExist(List<Menu> menus, String menu) {
        for (Menu m : menus) {
            validator.isValidMenuExist(m,menu);
        }
    }

    public void isValidMenuSum(List<Menu> menus) {
        int sum = 0;
        for (Menu m : menus) {
            sum = m.sumMenu(sum);
        }
        validator.isValidMenuSum(sum);
    }

    public void validateMenuByBeverage(List<Menu> menus) {
        long beverageMenuCount = menus.stream()
            .filter(m -> m.getMenuItem().getMenuCategory() == MenuCategory.BEVERAGE)
            .count();
        validator.isValidOnlyBeverage(beverageMenuCount, menus.size());
    }


}
