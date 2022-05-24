package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Lottos matchedLottos(WinningLotto winningNumbers, MatchResult matchResult) {
        List<Lotto> matchedLottos = lottos.stream()
                .filter(lotto -> winningNumbers.isMatched(lotto, matchResult))
                .collect(Collectors.toList());
        return Lottos.from(matchedLottos);
    }
    
    public int size() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Lotto lotto : lottos) {
            builder.append(lotto.sortLottoNumbers().toString() + "\n");
        }
        return builder.toString();
    }
}
