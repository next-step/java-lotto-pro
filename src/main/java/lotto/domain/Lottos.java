package lotto.domain;

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
}
