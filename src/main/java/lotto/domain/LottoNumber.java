package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또의 숫자는" + MIN_NUMBER + "~" + MAX_NUMBER + "까지만 허용합니다.");
        }
        return lottoNumber;
    }

    public static LottoNumber createBonusNumber(Lotto winnerLotto, int bonusNumber)
            throws IllegalArgumentException {
        LottoNumber lottoNumber = new LottoNumber(bonusNumber);
        if (winnerLotto.isContain(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨로또 번호에 포함되어 있으면 안된다");
        }
        return lottoNumber;
    }

    private void valid(int number) {



    }

    private boolean isNotNumberRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) target;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
