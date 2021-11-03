package lotto.domain;

import java.util.*;

public class Lotto {

    private static final int MAX_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(final List<Integer> lotto) {
        this.lotto = new HashSet(lotto);
        check();
    }

    private void check() {
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
