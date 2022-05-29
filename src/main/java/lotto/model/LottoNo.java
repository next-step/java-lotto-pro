package lotto.model;

import java.util.Objects;

public class LottoNo {
    private final int lottoNo;

    public LottoNo(int no) {
        this.lottoNo = checkLottoNumber(no);
    }

    public int value() {
        return lottoNo;
    }

    private int checkLottoNumber(int no) {
        if (no > 45 || no < 1 ) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
        }
        return no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }
}
