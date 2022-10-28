package step3.view;

import step3.model.LottoGenerator;

import java.util.Scanner;

import static step3.constant.Message.TOTAL_LOTTO_PRICE_INPUT_MESSAGE;
public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    public static void inputPurchasePrice(LottoGenerator lottoGenerator) {
        System.out.println(TOTAL_LOTTO_PRICE_INPUT_MESSAGE);
        lottoGenerator.setPurchasePrice(scanner.nextLine());
    }

}
