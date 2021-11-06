package lotto.domain;

import java.util.Objects;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(String numbers, int bonus) {
        this.winningLotto = new Lotto(numbers);
        this.bonus = bonus;
    }

    public Rank match(Lotto lotto) {
        final int matchCount = winningLotto.match(lotto);
        final boolean hasBonus = lotto.containBonus(new Bonus(bonus));
        return Rank.rank(matchCount, hasBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}
