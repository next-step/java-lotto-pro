package lotto.domain;

import java.util.Objects;

public class LottoNo{
    private final int lottoNumber;

    public LottoNo(int lottoNumber) {
        this.lottoNumber = validateNumberRange(lottoNumber);
    }

    public LottoNo(String lottoString) {
        try {
            lottoNumber = Integer.parseInt(lottoString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("로또볼은 숫자입니다.");
        }
        validateNumberRange(lottoNumber);
    }

    private int validateNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("번호는 1~45 사이 숫자입니다.");
        }
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    public LottoNo validateBonus(Lotto winningLotto) {
        if(winningLotto.getLottoNumbers().contains(this)){
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
}
