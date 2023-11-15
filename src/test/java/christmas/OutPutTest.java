package christmas;

import christmas.controller.OutputController;
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
        new Menu(MenuItem.BARBECUE_RIB, 1),
        new Menu(MenuItem.T_BONE_STEAK, 1),
        new Menu(MenuItem.CHOCOLATE_CAKE,2)
    );

    int firstDay = 3;
    int secondDay = 26;

    OutputView outputView = new OutputView();
    CalculateDiscountService calculateDiscountService = new CalculateDiscountService(menu, firstDay);

    @DisplayName("주문 메뉴 출력")
    @Test
    void printMenu() {
        outputView.printMenu(menu);
    }

    @DisplayName("메뉴 총합, 할인전")
    @Test
    void printPriceBeforeDiscount() {
        assertEquals(142000, calculateDiscountService.calculateTotalOrderAmountBeforeDiscount());
    }

    @DisplayName("증정메뉴")
    @Test
    void printGiftMenu(){
        assertEquals("삼페인 1개", calculateDiscountService.calculateGiftMenu(142000));
    }

//    @DisplayName("혜택내역")
//    @Test
//    void printDiscountDetail(){
//        OutputController outputController = new OutputController(menu,firstDay);
//        assertEquals("크리스마스 디데이 할인: -1,200원\n"
//            + "평일 할인: -4,046원\n"
//            + "특별 할인: -1,000원\n"
//            + "증정 이벤트: -25,000원",outputController.);
//    }

}
