package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_SIZE_NUM = 6;
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        validLottoSize(lotto);
        this.lotto = lotto;
    }

    public static Lotto from(List<Integer> lottoNumbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (int lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
        return new Lotto(lotto);
    }

    private void validLottoSize(List<LottoNumber> lotto) {
        if (isNotLottoSize(lotto.size())) {
            throw new IllegalArgumentException("로또 번호 갯수가 올바르지 않습니다.");
        }
    }

    private boolean isNotLottoSize(int size) {
         return size != LOTTO_SIZE_NUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
