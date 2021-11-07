package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final Money SELLING_PRICE = new Money(1000);

    private final LottoNumbers  numbers;

    private Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public static int howManyLottosCanIBuyWith(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return money.divideBy(SELLING_PRICE);
    }

    public static Lotto generate(List<Integer> numbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(new LottoNumber(number));
        }
        return new Lotto(new LottoNumbers(list));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
