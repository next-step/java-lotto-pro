package study.step3.view;

import study.step3.domain.lotto.PurchaseMoney;
import study.step3.message.LottoMachineMessage;

import java.util.regex.Pattern;

public class LottoMachineView {

    private static final String REGEX_ONLY_NUMBERS = "^[0-9]*$";
    private static final Pattern PATTERN_ONLY_NUMBERS = Pattern.compile(REGEX_ONLY_NUMBERS);

    public static PurchaseMoney inputPurchaseMoney() {
        String purchaseMoney = null;
        while (!validatePurchaseMoney(purchaseMoney)) {
            ResultView.output(LottoMachineMessage.INPUT_PURCHASE_MONEY_MESSAGE.message());
            purchaseMoney = InputView.input();
        }
        return PurchaseMoney.of(Long.parseLong(purchaseMoney));
    }

    private static boolean validatePurchaseMoney(String purchaseMoney) {
        if(purchaseMoney == null || purchaseMoney.isEmpty()) {
            return false;
        }
        return PATTERN_ONLY_NUMBERS.matcher(purchaseMoney).find();
    }
}
