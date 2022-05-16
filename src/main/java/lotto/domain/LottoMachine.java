package lotto.domain;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;

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

    public static LottoNumbers winningLottoNumbers(final String winningNumber) {
        return LottoNumbers.pickNumbers(splitLottoNumbers(winningNumber));
    }

    private static List<LottoNumber> splitLottoNumbers(final String winningNumber) {
        return Arrays.stream(winningNumber.trim().split(SPLITTER))
                .map(numberString -> LottoNumber.valueOf(numberString.trim()))
                .collect(Collectors.toList());
    }
}
