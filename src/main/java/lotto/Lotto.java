package lotto;

import static generic.Money.valueOf;
import static lotto.Lotto.LottoType.AUTO;
import static lotto.Lotto.LottoType.MANUAL;
import static util.ListUtils.randomPickCount;

import generic.Money;
import java.util.ArrayList;

public class Lotto {

    public enum LottoType {
        AUTO, MANUAL;

        public boolean isAuto() {
            return this == AUTO;
        }

    }

    public static final Money PURCHASE_PRICE = Money.valueOf(1000);

    private static final int PICK_COUNT_NUMBER = 6;
    private final LottoNumbers pickLottoNumbers;
    private final LottoType type;

    private Lotto() {
        this(pickNumbersRandom(), AUTO);
    }

    private Lotto(final LottoNumbers pickLottoNumbers, final LottoType type) {
        this.pickLottoNumbers = pickLottoNumbers;
        this.type = type;
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public static Lotto generate(final LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers, MANUAL);
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
