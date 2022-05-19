package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoScore calculateLottoScore(WinningNumbers winningNumbers) {
        LottoScore lottoScore = new LottoScore();

        lottos.forEach(lotto -> {
            int countOfMatch = lotto.getWinningOfNumbersCount(winningNumbers);
            Rank rank = Rank.valueOf(countOfMatch, winningNumbers.isContainsBonusNumber(lotto));
            lottoScore.addScore(rank);
        });

        return lottoScore;
    }

    public static Lottos merge(Lottos manual, Lottos auto) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manual.getLottos());
        lottos.addAll(auto.getLottos());
        return new Lottos(lottos);
    }

    public int size() {
        return this.lottos.size();
    }
}
