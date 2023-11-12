package christmas.controller;

import christmas.view.InputView;

public class InputController {

    public int dateController() {
        InputView inputView = new InputView();
        while (true) {
            try {
                return inputView.readDate();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}
