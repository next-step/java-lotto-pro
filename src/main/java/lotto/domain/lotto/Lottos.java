package lotto.domain.lotto;

import lotto.prize.Prize;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Prize, Integer> getPrizeOfLotto(WinnerLotto winnerLotto) {
        Map<Prize, Integer> prizes = new EnumMap<Prize, Integer>(Prize.class);
        for (Lotto lotto : lottos) {
            int count = lotto.matchCount(winnerLotto);
            boolean hasBonusBall = lotto.hasBonusNumber(winnerLotto);
            prizes.merge(Prize.prizeOf(count, hasBonusBall), 1, Integer::sum);
        }
        return prizes;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
