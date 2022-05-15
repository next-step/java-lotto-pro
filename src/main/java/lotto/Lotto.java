package lotto;

import static generic.Money.wons;
import static lotto.Lotto.LottoType.AUTO;
import static lotto.Lotto.LottoType.MANUAL;

import generic.Money;

public class Lotto {

    public enum LottoType {
        AUTO, MANUAL;

        public boolean isAuto() {
            return this == AUTO;
        }

    }
    public static final Money PURCHASE_PRICE = wons(1000);
    private final LottoNumbers pickLottoNumbers;
    private final LottoType type;

    private Lotto() {
        this(LottoNumbers.ALL_NUMBERS.pickNumbersRandom(), AUTO);
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

    public LottoWinResult confirm(final LottoNumbers winNumbers) {
        return LottoWinResult.confirm(pickLottoNumbers.compareCount(winNumbers));
    }

    public String toStringPickNumbers() {
        return this.pickLottoNumbers.toStringPickNumbers();
    }
}
