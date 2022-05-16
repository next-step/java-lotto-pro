package lotto;

import static util.ListUtils.randomPickCount;

import generic.Money;
import java.util.ArrayList;

public class Lotto {

    public static final Money PURCHASE_PRICE = Money.valueOf(1000);

    private static final int PICK_COUNT_NUMBER = 6;
    private final LottoNumbers pickLottoNumbers;

    private Lotto() {
        this(pickNumbersRandom());
    }

    private Lotto(final LottoNumbers pickLottoNumbers) {
        this.pickLottoNumbers = pickLottoNumbers;
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public static Lotto generate(final LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private static LottoNumbers pickNumbersRandom() {
        return new LottoNumbers(
                randomPickCount(new ArrayList<>(LottoNumber.ALL_LOTTO_NUMBERS), PICK_COUNT_NUMBER));
    }

    public LottoWinResult confirm(final LottoNumbers winNumbers) {
        return LottoWinResult.confirm(pickLottoNumbers.compareCount(winNumbers));
    }

    public String toStringPickNumbers() {
        return this.pickLottoNumbers.toStringPickNumbers();
    }
}
