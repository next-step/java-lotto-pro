package lotto.domain;

import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(String numbers) {
        this.lotto = new Lotto(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
