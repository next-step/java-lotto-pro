package lotto.view;

import lotto.utils.StringUtils;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getLottoPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("입력한 값이 올바르지 않아 로또 구매에 실패했습니다.");
        }
        return purchasePrice;

    }
}
