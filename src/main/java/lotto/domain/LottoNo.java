package lotto.domain;

import java.util.Objects;

public class LottoNo {
    private final int lottoNumber;

    public LottoNo(int lottoNumber) {
        this.lottoNumber = validateNumberRange(lottoNumber);
    }

    public static LottoNo createLotto(String lottoString) {
        int checkLottoNoInput;
        try {
            checkLottoNoInput = Integer.parseInt(lottoString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("로또볼은 숫자입니다.");
        }
        return new LottoNo(checkLottoNoInput);
    }

    private int validateNumberRange(int lottoNumber) {
        if (lottoNumber < Lotto.LOTTO_NO_START_NUMBER || lottoNumber > Lotto.LOTTO_NO_END_NUMBER) {
            String exceptionMessage = String.format("번호는 %d ~ %d 사이 숫자입니다.", Lotto.LOTTO_NO_START_NUMBER,
                    Lotto.LOTTO_NO_END_NUMBER);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return lottoNumber;
    }

    public LottoNo validateBonus(Lotto winningLotto) {
        if (winningLotto.getLottoNumbers().contains(this)) {
            throw new IllegalArgumentException("보너스는 당첨 숫자와 달라야합니다.");
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNo)) {
            return false;
        }
        LottoNo lottoNo = (LottoNo) o;
        return lottoNumber == lottoNo.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
