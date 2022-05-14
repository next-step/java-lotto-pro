package lotto;

import static generic.Money.wons;
import static lotto.Lotto.LottoType.AUTO;

import generic.Money;

public class Lotto {

    public enum LottoType {
        AUTO;

        public boolean isAuto() {
            return this == AUTO;
        }

    }
    public static final Money PURCHASE_PRICE = wons(1000);
    private final LottoNumbers pickLottoNumbers;

    private final LottoType type;
    private Lotto() {
        this(LottoNumbers.ALL_NUMBERS.pickNumbers(), AUTO);
    }
    private Lotto(final LottoNumbers pickLottoNumbers, final LottoType type) {
        this.pickLottoNumbers = pickLottoNumbers;
        this.type = type;
    }

    public static Lotto auto() {
        return new Lotto();
    }

    public LottoWinResult confirm(final LottoNumbers winNumbers) {
        return LottoWinResult.confirm(pickLottoNumbers.compareCount(winNumbers));
    }

    public String toStringPickNumbers() {
        return this.pickLottoNumbers.toStringPickNumbers();
    }
}
