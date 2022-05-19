package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Lottos matchedLottoList(WinningNumbers winningNumbers, MatchResult matchResult) {
        List<Lotto> matchedLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            if (winningNumbers.isMatched(lotto, matchResult)) {
                matchedLottos.add(lotto);
            }
        }
        return Lottos.from(matchedLottos);
    }

    public Money totalPrice() {
        Money result = Money.from(0);
        for (Lotto lotto : lottos) {
            result = result.add(lotto.price());
        }

        return result;
    }

    public int size() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Lotto lotto : lottos) {
            builder.append(lotto.sortedLottoNumbers().toString() + "\n");
        }
        return builder.toString();
    }
}
