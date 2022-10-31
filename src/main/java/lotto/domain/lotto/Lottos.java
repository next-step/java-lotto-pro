package lotto.domain.lotto;

import lotto.prize.Prize;
import lotto.prize.Prizes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Prizes getPrizeOfLotto(WinnerLotto winnerLotto) {
        List<Prize> resultPrizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.prizeOf(lotto.matchCount(winnerLotto), lotto.hasBonusNumber(winnerLotto));
            resultPrizes.add(prize);
        }
        return new Prizes(resultPrizes);
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
