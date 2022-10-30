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

    public int divide(Money divisor) {
        return (int) (money / divisor.money);
    }

    public String rate(long price) {
        return new DecimalFormat("#.##")
                .format((float) price / money);
    }
}
