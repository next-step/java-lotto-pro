package step3.veiw;

import step3.model.LottoGenerator;

import java.util.Scanner;

import static step3.constant.GameMessage.PURCHASE_PRICE_MESSAGE;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static void inputPurchasePrice(LottoGenerator lottoGenerator) {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        lottoGenerator.initPurchasePrice(scanner.nextLine());
    }

}
