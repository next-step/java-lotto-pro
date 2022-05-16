package lotto;

import static generic.Money.valueOf;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final String SPLITTER = ",";
    private final Round round;

    public LottoMachine(final String purchaseMoneyString) {
        this.round = Round.start(purchase(valueOf(purchaseMoneyString.trim())));
    }

    private Lottos purchase(final Money purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        return Lottos.purchaseAuto(purchaseMoney);
    }

    private void validatePurchaseMoney(final Money purchaseMoney) {
        if (purchaseMoney.isLessThan(Lotto.PURCHASE_PRICE)) {
            throw new IllegalArgumentException("로또를 구매 할 수 없습니다.");
        }
    }

    public void end(final String winningNumber) {
        round.end(LottoNumbers.pickNumbers(splitLottoNumbers(winningNumber)));
    }

    private List<LottoNumber> splitLottoNumbers(final String winningNumber) {
        return Arrays.stream(winningNumber.trim().split(SPLITTER))
                .map(numberString -> LottoNumber.valueOf(numberString.trim()))
                .collect(Collectors.toList());
    }

    public Round round() {
        return this.round;
    }
}
