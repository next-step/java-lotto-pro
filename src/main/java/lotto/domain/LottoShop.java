package lotto.domain;

import lotto.validator.PriceValidatorGroup;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;
    private static final PriceValidatorGroup validatorGroup = PriceValidatorGroup.getInstance();

    public static Lottos sale(int price) {
        validatorGroup.validate(price);
        return LottoMachine.createLottos(price);
    }
}
