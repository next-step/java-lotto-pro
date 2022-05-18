package lotto.domain;

import static lotto.domain.Lotto.LottoType.AUTO;
import static lotto.domain.Lotto.LottoType.MANUAL;
import static util.ListUtils.randomPickCount;

import generic.Money;
import java.util.ArrayList;
import java.util.Objects;

public class Lotto {


    public enum LottoType {
        AUTO, MANUAL;

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

    public LottoWinResult confirm(final WinningNumbers winNumbers) {
        return LottoWinResult.confirm(pickLottoNumbers.compareCount(winNumbers.getLottoNumbers()),
                pickLottoNumbers.contains(winNumbers.getBonusNumber()));
    }

    public LottoNumbers numbers() {
        return this.pickLottoNumbers;
    }

    public boolean isManual() {
        return type == MANUAL;
    }

    public boolean isAuto() {
        return type == AUTO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        final Lotto lotto = (Lotto) o;
        return Objects.equals(pickLottoNumbers, lotto.pickLottoNumbers) && type == lotto.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickLottoNumbers, type);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "pickLottoNumbers=" + pickLottoNumbers +
                ", type=" + type +
                '}';
    }
}
