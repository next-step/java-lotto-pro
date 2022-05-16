package lotto.domain;

import lotto.domain.validator.PriceValidatorGroup;

public class LottoShop {

    private static final PriceValidatorGroup validatorGroup = PriceValidatorGroup.getInstance();

    public static Lottos sale(int price) {
        validatorGroup.validate(price);
        return LottoMachine.createLottos(price);
    }
}
