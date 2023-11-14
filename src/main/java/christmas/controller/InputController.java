package christmas.controller;

import christmas.domain.Menu;
import christmas.exception.CustomException;
import christmas.model.MenuService;
import christmas.model.Validator;
import christmas.view.InputView;
import java.util.List;

public class InputController {

    Validator validator = new Validator();
    InputView inputView = new InputView();
    MenuService menuService = new MenuService();

    public int dateController() {
        while (true) {
            try {
                String input = inputView.readDate();
                int day = validator.isValidNumeric(input,"controller");
                validator.isValidDay(day);
                return day;
            } catch (CustomException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Menu> menuController() {
        while (true) {
            try {
                String input = inputView.readMenu();
                validator.isValidMenuFormat(input);
                List<Menu> menus = menuService.createMenu(input);
                menuService.isValidMenuSum(menus);
                menuService.validateMenuByBeverage(menus);
                return menus;
            } catch (CustomException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

}
