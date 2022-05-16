package lotto.domain;

import java.util.List;
import lotto.constants.Matched;

public class LottosWinningStatistics {
    private final Lottos lottos;
    private final LottoWinningNumbers winningNumbers;

    public LottosWinningStatistics(final Lottos lottos, final LottoWinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public int calculateTotalReward(final List<Integer> matches) {
        int totalReward = 0;
        for (final Integer match : matches) {
            totalReward += calculateReward(match);
        }
        return totalReward;
    }

    private int calculateReward(final Integer match) {
        return Matched.getByCount(match)
                .getReward();
    }

    public List<Integer> getWinningMatches() {
        return lottos.matchWinningNumber(winningNumbers);
    }

    public int getWinningMatchedCount(final int matchedCount) {
        return (int) getWinningMatches().stream()
                .filter(match -> match == matchedCount)
                .count();
    }

    public List<Integer> getWinningMatchesUsingBonus(final boolean isEqualBonus) {
        return lottos.matchWinningNumberUsingBonus(winningNumbers, isEqualBonus);
    }

    public int getWinningMatchedCountUsingBonus(final int matchedCount, final boolean isEqualBonus) {
        return (int) getWinningMatchesUsingBonus(isEqualBonus).stream()
                .filter(match -> match == matchedCount)
                .count();
    }

    public Price getPrice() {
        return new Price(lottos.getLottosCount() * Lotto.LOTTO_FIXED_PRICE);
    }
}
