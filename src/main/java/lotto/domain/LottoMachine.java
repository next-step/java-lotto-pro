package lotto.domain;

import static java.util.Arrays.stream;

import generic.Money;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final String SPLITTER = ",";

    private LottoMachine() {
    }

    public static PurchaseLottos purchase(final String purchaseMoneyString, final String[] manualNumbersStrings) {
        final Money calculateAutoMoney = calculateAutoMoney(Money.valueOf(purchaseMoneyString), manualNumbersStrings.length);
        validatePurchaseMoney(calculateAutoMoney, manualNumbersStrings.length);
        return PurchaseLottos.of(purchaseManual(manualNumbersStrings), purchase(calculateAutoMoney));
    }

    private static Lottos purchaseManual(final String[] manualNumbersString) {
        return Lottos.of(stream(manualNumbersString)
                .map(LottoMachine::splitLottoNumbers)
                .map(LottoNumbers::pickNumbers)
                .map(Lotto::generate)
                .toArray(Lotto[]::new));
    }

    private static Money calculateAutoMoney(final Money purchaseMoney, final int purchaseManualCount) {
        return purchaseMoney.minus(Lotto.PURCHASE_PRICE.times(purchaseManualCount));
    }

    public static Lottos purchase(final Money purchaseMoney) {
        return Lottos.purchaseAuto(purchaseMoney);
    }

    private static void validatePurchaseMoney(final Money calculateAutoMoney, final int manualCount) {
        if (calculateAutoMoney.isLessThan(Money.ZERO)) {
            throw new IllegalArgumentException("금액을 초과하여 구매할 수 없습니다.");
        }

        if (manualCount < 1 && calculateAutoMoney.isLessThan(Lotto.PURCHASE_PRICE)) {
            throw new IllegalArgumentException("로또를 구매 할 수 없습니다.");
        }
    }

    public static WinningNumbers winningLottoNumbers(final String winningNumber, final String bonusNumber) {
        return WinningNumbers.of(LottoNumbers.pickNumbers(splitLottoNumbers(winningNumber)),
                LottoNumber.valueOf(bonusNumber));
    }

    private static List<LottoNumber> splitLottoNumbers(final String winningNumber) {
        return stream(winningNumber.trim().split(SPLITTER))
                .map(numberString -> LottoNumber.valueOf(numberString.trim()))
                .collect(Collectors.toList());
    }
}
