package christmas.view;

import christmas.domain.Menu;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {

    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printMenu(List<Menu> menu) {
        System.out.println("\n<주문 메뉴>");
        for (Menu m : menu) {
            System.out.println(m.toString());
        }
    }

    public void printTotalOrderAmountBeforeDiscount(int totalBeforeDiscount) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(totalBeforeDiscount));
    }

    public void printGiftMenu(String message) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(message);
    }

    public void printBenefitDetailsOverMan(Map<String, Integer> benefitDetail) {
        System.out.println("\n<혜택 내역>");
        StringJoiner stringJoiner = new StringJoiner("\n");

        for (Map.Entry<String, Integer> map : benefitDetail.entrySet()) {
            if (map.getValue() != 0) {
                stringJoiner.add(map.getKey() + ": -" + decimalFormat.format(map.getValue()) + "원");
            }
        }

        String result = stringJoiner.toString();
        System.out.println(result);
    }

    public void printBenefitDetailsUnderMan() {
        System.out.println("\n<혜택 내역>");
        System.out.println("없음");
    }

    public void printTotalBenefitAmount(int benefitAmount) {
        System.out.println("\n<총혜택 금액>");
        if (benefitAmount == 0) {
            System.out.println(0 + "원");
            return;
        }
        System.out.println("-" + decimalFormat.format(benefitAmount) + "원");
    }

    public void printDiscountedTotalAmount(int totalAmount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(decimalFormat.format(totalAmount) + "원");
    }

    public void printEventBadge(String eventBadge) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }
}