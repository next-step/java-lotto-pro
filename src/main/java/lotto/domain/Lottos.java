package lotto.domain;

import java.util.List;
import lotto.domain.calculator.RankCalculationFactory;
import lotto.domain.calculator.RankCalculator;

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
            RankCalculator rankCalculator = RankCalculationFactory.getRankCalculator(lotto, winningNumbers);
            Rank rank = Rank.valueOf(countOfMatch, rankCalculator);
            lottoScore.addScore(rank);
        });

        return lottoScore;
    }
}
