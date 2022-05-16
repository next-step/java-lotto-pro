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
            int winningNumberCount = lotto.getWinningOfNumbersCount(winningNumbers.getWinningNumbers());
            addLottoScore(lottoScore, winningNumberCount);
        });

        return lottoScore;
    }

    private void addLottoScore(LottoScore lottoScore, int winningNumberCount) {
        LottoWinnings lottoWinnings = LottoWinnings.getWinningsByCount(winningNumberCount);
        if (!lottoWinnings.isNone()) {
            lottoScore.addScore(lottoWinnings);
        }
    }
}
