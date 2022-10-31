package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    protected final LottoNumbers numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public boolean hasBonusBall(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    @Override
    public String toString() {
        return "[" + numbers + "]";
    }
}
