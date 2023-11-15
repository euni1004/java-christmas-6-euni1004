package christmas.controller;

import christmas.domain.Menu;
import christmas.model.CalculateDiscountService;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputController {

    private final List<Menu> menu;
    private final int day;

    public OutputController(List<Menu> menu, int day) {
        this.menu = menu;
        this.day = day;
    }

    public void outputController() {
        CalculateDiscountService calculateDiscountService = new CalculateDiscountService(menu, day);
        OutputView outputView = new OutputView();

        int totalAmountBeforeDiscount = calculateDiscountService.calculateTotalOrderAmountBeforeDiscount();

        outputView.printMenu(menu);
        outputView.printTotalOrderAmountBeforeDiscount(totalAmountBeforeDiscount);
        outputView.printGiftMenu(calculateDiscountService.calculateGiftMenu(totalAmountBeforeDiscount));

        int benefitAmount = calculateBenefitAndPrintDetails(outputView, totalAmountBeforeDiscount,
            calculateDiscountService);

        outputView.printTotalBenefitAmount(benefitAmount);
        outputView.printDiscountedTotalAmount(
            calculateDiscountService.calculateDiscountTotalAmount(totalAmountBeforeDiscount, benefitAmount));
        outputView.printEventBadge(calculateDiscountService.calculateEventBadge(benefitAmount));
    }

    private int calculateBenefitAndPrintDetails(OutputView outputView, int totalAmountBeforeDiscount,
        CalculateDiscountService calculateDiscountService) {
        int benefitAmount = 0;
        if (totalAmountBeforeDiscount >= 10000) {
            Map<String, Integer> benefitDetail = calculateDiscountService.printBenefitDetailsController(totalAmountBeforeDiscount);
            outputView.printBenefitDetailsOverMan(benefitDetail);
            benefitAmount = calculateDiscountService.calculateTotalDiscount(benefitDetail);
        }
        if (totalAmountBeforeDiscount < 10000) {
            outputView.printBenefitDetailsUnderMan();
        }
        return benefitAmount;
    }

}
