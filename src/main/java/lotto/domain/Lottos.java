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

        lottos.forEach(x -> {
            int winningNumberCount = x.getWinningOfNumbersCount(winningNumbers.getWinningNumbers());
            addLottoScore(lottoScore, winningNumberCount);
        });

        return lottoScore;
    }

    private void addLottoScore(LottoScore lottoScore, int winningNumberCount) {
        LottoWinnings lottoWinnings = LottoWinnings.getWinningsByCount(winningNumberCount);
        if (lottoWinnings != null) {
            lottoScore.addScore(lottoWinnings);
        }
    }
}
