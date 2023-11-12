package christmas;

import christmas.controller.InputController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputController inputController = new InputController();
        int day = inputController.dateController();
    }
}
