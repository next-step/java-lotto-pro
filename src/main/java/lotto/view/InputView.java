package lotto.view;

import lotto.utils.StringUtils;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static int getLottoPurchasePrice() {
        System.out.println("구매금액을 입력해 주세요.");
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("값이 올바르지 않습니다.");
        }
        return purchasePrice;

    }
}
