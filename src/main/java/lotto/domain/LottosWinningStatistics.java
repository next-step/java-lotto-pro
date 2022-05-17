package lotto.domain;

import lotto.constants.Matched;

public class LottosWinningStatistics {
    private final Lottos lottos;
    private final LottoWinningNumbers winningNumbers;

    public LottosWinningStatistics(final Lottos lottos, final LottoWinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public int calculateTotalReward(final LottoMatches matches) {
        int totalReward = 0;
        for (final Matched match : matches.getLottoMatches()) {
            totalReward += calculateReward(match);
        }
        return totalReward;
    }

    private int calculateReward(final Matched match) {
        return match.getReward();
    }

    public LottoMatches getWinningMatches() {
        return new LottoMatches(lottos.matchWinningNumber(winningNumbers));
    }

    public Price getPrice() {
        return new Price(lottos.getLottosCount() * Lotto.LOTTO_FIXED_PRICE);
    }
}
