package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public int size() {
        return this.values.size();
    }

    public int matches(int expectedMatchCount, LottoNumbers winningNumbers) {
        int matchCount = 0;
        for (Lotto lotto : values) {
            matchCount = getMatchCount(lotto, winningNumbers, expectedMatchCount, matchCount);
        }
        return matchCount;
    }

    private int getMatchCount(Lotto lotto, LottoNumbers winningNumbers, int expectedMatchCount, int matchCount) {
        if (lotto.matches(winningNumbers) == expectedMatchCount) {
            matchCount++;
        }
        return matchCount;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(values);
    }
}
