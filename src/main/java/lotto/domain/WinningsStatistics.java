package lotto.domain;

import lotto.domain.exception.DuplicateOfBonusBallNumberException;

import java.util.EnumMap;
import java.util.List;

public final class WinningsStatistics {

    private static final int LOTTO_PRICE = 1_000;

    private final EnumMap<Rank, Integer> result;

    private WinningsStatistics(final EnumMap<Rank, Integer> result) {
        this.result = result;
    }

    public static WinningsStatistics statistics(final Lotto winningLotto, final LottoNumber bonusBall, final Lottos lottos)  {
        validate(winningLotto, bonusBall);

        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        putMatchCountByRank(result, winningLotto, bonusBall, lottos);

        return new WinningsStatistics(result);
    }

    private static void validate(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if (winningLotto.isContainLottoNumber(bonusNumber)) {
            throw new DuplicateOfBonusBallNumberException();
        }
    }

    private static void putMatchCountByRank(final EnumMap<Rank, Integer> result, final Lotto winningLotto, final LottoNumber bonusBall, final Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            int matchingCount = winningLotto.countMatchingNumber(lotto);
            boolean isBonus = lotto.isContainLottoNumber(bonusBall);
            Rank findedRank = Rank.findRank(matchingCount, isBonus);
            result.put(findedRank, result.getOrDefault(findedRank, 0) + 1);
        }

    }

    public double calculatePrizeMoney() {
        int totalPrize = 0;
        int lottoCount = 0;

        for (Rank rank : result.keySet()) {
            totalPrize += rank.totalWinningMoney(result.get(rank));
            lottoCount += result.get(rank);
        }

        return (double) totalPrize / (lottoCount * LOTTO_PRICE);
    }

    public int getRankHitsCount(final Rank rank) {
        return result.get(rank);
    }

}
