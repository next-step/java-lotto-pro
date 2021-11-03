package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int MAX_SIZE = 6;
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(final List<Integer> lotto) {
        check(lotto);
        for (Integer number : lotto) {
            this.lotto.add(new LottoNumber(number));
        }
    }

    private void check(List<Integer> lotto) {
        if (lotto.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
