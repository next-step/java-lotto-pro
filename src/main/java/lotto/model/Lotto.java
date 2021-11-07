package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final Money SELLING_PRICE = new Money(1000);

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static int howManyLottosCanIBuyWith(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return money.divideBy(SELLING_PRICE);
    }

    public static Lotto generate(int... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new Lotto(lottoNumbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
