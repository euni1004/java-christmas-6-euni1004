package christmas;

import christmas.domain.Menu;
import christmas.enumClass.menu.MenuItem;
import christmas.exception.CustomException;
import christmas.model.InputService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class InputTest {

    @Test
    void testChangeStringToListMenu() {
        String input = "파스타-1";
        InputService inputService = new InputService();
        assertArrayEquals(inputService.splitMenuToComma(input), new String[]{input});
    }

    @Test
    void testValidMenu() {
        String input = "타파스-1,티본스테이크-1,타파스-1";
        InputService inputService = new InputService();
        assertThatThrownBy(() -> inputService.validMenu(input)).isInstanceOf(CustomException.class);
    }

    @Test
    void testValidMenuTrue() {
        String input = "타파스-1,티본스테이크-1";
        InputService inputService = new InputService();
        List<Menu> expectedMenus = Arrays.asList(
            new Menu(MenuItem.TAPAS, 1),
            new Menu(MenuItem.T_BONE_STEAK, 1)
        );

        List<Menu> actualMenus = inputService.validMenu(input);
        assertEquals(expectedMenus.size(), actualMenus.size());
        for (int i = 0; i < expectedMenus.size(); i++) {
            assertEquals(expectedMenus.get(i).toString(), actualMenus.get(i).toString());
        }
    }

    @Test
    void testValidateMenuByBeverage(){
        List<Menu> expectedMenus = Arrays.asList(
            new Menu(MenuItem.ZERO_COLA, 1),
            new Menu(MenuItem.RED_WINE, 1)
        );
        InputService inputService = new InputService();
        assertThatThrownBy(() -> inputService.validateMenuByBeverage(expectedMenus)).isInstanceOf(CustomException.class);
    }

    @Test
    void testValidateMenuByBeverageNoError(){
        List<Menu> expectedMenus = Arrays.asList(
            new Menu(MenuItem.ZERO_COLA, 1),
            new Menu(MenuItem.RED_WINE, 1),
            new Menu(MenuItem.T_BONE_STEAK, 1)
        );
        InputService inputService = new InputService();
        assertDoesNotThrow(() -> inputService.validateMenuByBeverage(expectedMenus));
    }

    @Test
    void testd(){
        String input = "해산물파스타-2,레드와인-1,초코케이크-1";
        String regex = "^[\\w가-힣]+-\\d+(,[\\w가-힣]+-\\d+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("정규식 일치!");
        } else {
            System.out.println("정규식 불일치!");
        }
    }

}
