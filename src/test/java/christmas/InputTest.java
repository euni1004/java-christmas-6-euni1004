package christmas;

import christmas.domain.Menu;
import christmas.enumClass.menu.MenuItem;
import christmas.exception.CustomException;
import christmas.model.MenuService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class InputTest {

    @DisplayName("메뉴를 하나만 주문했을때 분리가능한지")
    @Test
    void testChangeStringToListMenu() {
        String input = "파스타-1";
        MenuService menuService = new MenuService();
        assertArrayEquals(menuService.splitMenuToComma(input), new String[]{input});
    }

    @DisplayName("중복된 메뉴 주문시")
    @Test
    void testValidMenu() {
        String input = "타파스-1,티본스테이크-1,타파스-1";
        MenuService menuService = new MenuService();
        assertThatThrownBy(() -> menuService.createMenu(input)).isInstanceOf(CustomException.class);
    }

    @DisplayName("형식이 맞는 메뉴를 주문했을때 Menu객체로 만들어지는지")
    @Test
    void testValidMenuTrue() {
        String input = "타파스-1,티본스테이크-1";
        MenuService menuService = new MenuService();
        List<Menu> expectedMenus = Arrays.asList(
            new Menu(MenuItem.TAPAS, 1),
            new Menu(MenuItem.T_BONE_STEAK, 1)
        );

        List<Menu> actualMenus = menuService.createMenu(input);
        assertEquals(expectedMenus.size(), actualMenus.size());
        for (int i = 0; i < expectedMenus.size(); i++) {
            assertEquals(expectedMenus.get(i).toString(), actualMenus.get(i).toString());
        }
    }

    @DisplayName("모든 메뉴가 음료일경우")
    @Test
    void testValidateMenuByBeverage(){
        List<Menu> expectedMenus = Arrays.asList(
            new Menu(MenuItem.ZERO_COLA, 1),
            new Menu(MenuItem.RED_WINE, 1)
        );
        MenuService menuService = new MenuService();
        assertThatThrownBy(() -> menuService.validateMenuByBeverage(expectedMenus)).isInstanceOf(CustomException.class);
    }

    @DisplayName("음료+음식 주문시")
    @Test
    void testValidateMenuByBeverageNoError(){
        List<Menu> expectedMenus = Arrays.asList(
            new Menu(MenuItem.ZERO_COLA, 1),
            new Menu(MenuItem.RED_WINE, 1),
            new Menu(MenuItem.T_BONE_STEAK, 1)
        );
        MenuService menuService = new MenuService();
        assertDoesNotThrow(() -> menuService.validateMenuByBeverage(expectedMenus));
    }

    @DisplayName("음료 여부에 따른 테스트")
    @ParameterizedTest
    @CsvSource({
        "ZERO_COLA, 1, true",
        "RED_WINE, 1, true",
        "T_BONE_STEAK, 1, false"
    })
    void testValidateMenuByBeverage(MenuItem menuItem, int count, boolean expectError) {
        MenuService menuService = new MenuService();
        List<Menu> expectedMenus = Collections.singletonList(new Menu(menuItem, count));

        if (expectError) {
            assertThatThrownBy(() -> menuService.validateMenuByBeverage(expectedMenus))
                .isInstanceOf(CustomException.class);
        } else {
            assertDoesNotThrow(() -> menuService.validateMenuByBeverage(expectedMenus));
        }
    }

    @DisplayName("정규식 테스트")
    @Test
    void testRegex(){
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
