package christmas.controller;

import christmas.model.InputService;
import christmas.model.Validator;
import christmas.view.InputView;

public class InputController {

    InputService inputService = new InputService();
    Validator validator = new Validator();

    public int dateController(String input) {

        while (true) {
            try {
                int day = validator.isNumeric(input);
                validator.isValidDay(day);
                return day;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void menuController(){

    }

}
