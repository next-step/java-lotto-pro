package lotto.domain;

import lotto.domain.validator.PriceValidatorGroup;

public class Price {
    private int price;

    public Price(int price) {
        PriceValidatorGroup validatorGroup = PriceValidatorGroup.getInstance();
        validatorGroup.validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void spend(int price) {
        this.price -= price;
    }
}
