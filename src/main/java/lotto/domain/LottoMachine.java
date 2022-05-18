package lotto.domain;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final String SPLITTER = ",";

    private LottoMachine() {
    }

    public static Lottos purchase(final String purchaseMoneyString) {
        return purchase(Money.valueOf(purchaseMoneyString));
    }

    public static Lottos purchase(final Money purchaseMoney) {
        validatePurchaseMoney(purchaseMoney);
        return Lottos.purchaseAuto(purchaseMoney);
    }

    private static void validatePurchaseMoney(final Money purchaseMoney) {
        if (purchaseMoney.isLessThan(Lotto.PURCHASE_PRICE)) {
            throw new IllegalArgumentException("로또를 구매 할 수 없습니다.");
        }
    }

    public static WinningNumbers winningLottoNumbers(final String winningNumber, final String bonusNumber) {
        return WinningNumbers.of(LottoNumbers.pickNumbers(splitLottoNumbers(winningNumber)), LottoNumber.valueOf(bonusNumber)) ;
    }

    private static List<LottoNumber> splitLottoNumbers(final String winningNumber) {
        return Arrays.stream(winningNumber.trim().split(SPLITTER))
                .map(numberString -> LottoNumber.valueOf(numberString.trim()))
                .collect(Collectors.toList());
    }
}
