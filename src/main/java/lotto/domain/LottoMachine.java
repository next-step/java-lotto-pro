package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int PRICE = 1000;
    private static final int ZERO = 0;

    public static List<Lotto> purchase(final long money) {
        validate(money);
        return generateAuto(calculate(new Money(money)));
    }

    private static void validate(final long money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("금액 부족");
        }
    }

    private static int calculate(final Money money) {
        return (int) (money.getMoney() / PRICE);
    }

    public static List<Lotto> generateAuto(final int count) {
        return IntStream.range(ZERO, count)
                .mapToObj(i -> Lotto.auto())
                .collect(Collectors.toList());
    }
}
