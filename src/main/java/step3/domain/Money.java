package step3.domain;

import java.text.DecimalFormat;

public class Money {

    private final long money;

    private Money(long money) {
        this.money = money;
    }

    public static Money generate(long money) {
        return new Money(money);
    }

    public void validate(Money pricePerLotto) {
        if (getPurchaseCount(pricePerLotto) == 0) {
            throw new IllegalArgumentException("You don't have enough money.");
        }
    }

    public int getPurchaseCount(Money pricePerLotto) {
        return (int) (money / pricePerLotto.money);
    }

    public String rate(long price) {
        return new DecimalFormat("#.##")
                .format((float) price / money);
    }
}
