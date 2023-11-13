package christmas.controller;

import christmas.domain.Menu;
import christmas.model.InputService;
import christmas.model.Validator;
import christmas.view.InputView;
import java.util.List;

public class InputController {

    Validator validator = new Validator();
    InputView inputView = new InputView();
    InputService inputService = new InputService();

    public int dateController() {
        while (true) {
            try {
                String input = inputView.readDate();
                int day = validator.isNumeric(input);
                validator.isValidDay(day);
                return day;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Menu> menuController(){
        while (true){
            try{
                String input = inputView.readMenu();
                validator.isValidMenuFormat(input);
                List<Menu> menus = inputService.validMenu(input);
                inputService.isValidMenuSum(menus);
                inputService.validateMenuByBeverage(menus);
                return menus;
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }

    }

}
