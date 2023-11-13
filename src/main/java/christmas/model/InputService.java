package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class InputService {

    public int changeStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public List<String> changeStringToListMenu(String input) {
        return List.of(input.split(","));
    }

    public List<String> splitMenuToBar(List<String> tempMenu) {
        List<String> menu = new ArrayList<>();
        for (String temp: tempMenu) {
            String[] parts = temp.split("-");
        }
        return menu;
    }

}
