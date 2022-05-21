package lotto;

import static java.util.Arrays.stream;

import generic.Money;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class InputPurchaseDto {

    private final String purchaseMoneyString;
    private final String[] manualNumbersStrings;
    private final Money calculateAutoMoney;

    private InputPurchaseDto(final String purchaseMoneyString, final String[] manualNumbersStrings) {
        this.purchaseMoneyString = purchaseMoneyString;
        this.manualNumbersStrings = manualNumbersStrings;
        this.calculateAutoMoney = calculateAutoMoney(Money.valueOf(purchaseMoneyString), manualNumbersStrings.length);
        validatePurchaseMoney(calculateAutoMoney, manualNumbersStrings.length);
    }

    public static InputPurchaseDto of(final String purchaseMoneyString, final String[] manualNumbersStrings) {
        return new InputPurchaseDto(purchaseMoneyString, manualNumbersStrings);
    }

    private void validatePurchaseMoney(final Money calculateAutoMoney, final int manualCount) {
        if (calculateAutoMoney.isLessThan(Money.ZERO)) {
            throw new IllegalArgumentException("금액을 초과하여 구매할 수 없습니다.");
        }

        if (manualCount < 1 && calculateAutoMoney.isLessThan(Lotto.PURCHASE_PRICE)) {
            throw new IllegalArgumentException("로또를 구매 할 수 없습니다.");
        }
    }

    private static Money calculateAutoMoney(final Money purchaseMoney, final int purchaseManualCount) {
        return purchaseMoney.minus(Lotto.PURCHASE_PRICE.times(purchaseManualCount));
    }

    public Money calculateAutoMoney() {
        return calculateAutoMoney;
    }

    public Lotto[] mapToLottoArray() {
        return stream(this.manualNumbersStrings)
                .map(LottoNumbersMapper::mapToLottoNumbers)
                .map(LottoNumbers::pickNumbers)
                .map(Lotto::generate)
                .toArray(Lotto[]::new);
    }

}
