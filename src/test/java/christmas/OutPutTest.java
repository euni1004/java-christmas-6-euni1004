package christmas;

import christmas.domain.Menu;
import christmas.enumClass.menu.MenuItem;
import christmas.model.CalculateDiscountService;
import christmas.view.OutputView;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutPutTest {

    List<Menu> menu = Arrays.asList(
        new Menu(MenuItem.ZERO_COLA, 1),
        new Menu(MenuItem.RED_WINE, 1),
        new Menu(MenuItem.T_BONE_STEAK, 1)
    );

    OutputView outputView = new OutputView();
    CalculateDiscountService calculateDiscountService = new CalculateDiscountService(menu,3);

    @DisplayName("주문 메뉴 출력")
    @Test
    void printMenu(){
        outputView.printMenu(menu);
    }

//    @DisplayName("메뉴 총합, 할인전")
//    @Test
//    void printPriceBeforeDiscount(){
//        assertEquals(118000,calculateDiscountService.calculateTotalOrderAmountBeforeDiscount(menu));
//    }

}
