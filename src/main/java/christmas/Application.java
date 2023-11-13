package christmas;

import christmas.controller.InputController;
import christmas.domain.Menu;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputController inputController = new InputController();
        int day = inputController.dateController();

        List<Menu> menu = inputController.menuController();
    }
}
