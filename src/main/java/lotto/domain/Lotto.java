package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(final List<Integer> lotto) {
        for (Integer number : lotto) {
            this.lotto.add(new LottoNumber(number));
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
