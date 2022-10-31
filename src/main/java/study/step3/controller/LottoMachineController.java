package study.step3.controller;

import study.step3.domain.lotto.*;
import study.step3.message.LottoMachineMessage;
import study.step3.view.InputView;
import study.step3.view.ResultView;

import java.util.regex.Pattern;

public class LottoMachineController {

    private static final String REGEX_ONLY_NUMBERS = "^[0-9]*$";
    private static final Pattern PATTERN_ONLY_NUMBERS = Pattern.compile(REGEX_ONLY_NUMBERS);
    private final LottoIssuanceStrategy lottoIssuanceStrategy;

    public LottoMachineController(LottoIssuanceStrategy lottoIssuanceStrategy) {
        this.lottoIssuanceStrategy = lottoIssuanceStrategy;
    }

    public Lottos issueLottos(PurchaseMoney purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, lottoIssuanceStrategy);
        return lottoMachine.issueLottos();
    }

    public PurchaseMoney inputPurchaseMoney() {
        String purchaseMoney = null;
        while (!validatePurchaseMoney(purchaseMoney)) {
            ResultView.output(LottoMachineMessage.INPUT_PURCHASE_MONEY_MESSAGE.message());
            purchaseMoney = InputView.input();
        }
        return PurchaseMoney.of(Long.parseLong(purchaseMoney));
    }

    private boolean validatePurchaseMoney(String purchaseMoney) {
        if(purchaseMoney == null || purchaseMoney.isEmpty()) {
            return false;
        }
        return PATTERN_ONLY_NUMBERS.matcher(purchaseMoney).find();
    }
}
