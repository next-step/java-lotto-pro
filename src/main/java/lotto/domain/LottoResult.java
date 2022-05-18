package lotto.domain;

import lotto.infrastructure.error.LottoWinningResultErrorCode;

import java.util.*;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounter;

    public LottoResult() {
        this.rankCounter = new HashMap<>();
        init();
    }

    public void init() {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounter.put(rank, 0));
    }

    public void countLottoRank(final WinningLottoTicket winningLottoTicket, final LottoTicket purchasedLottoTicket) {
        validateNull(winningLottoTicket, purchasedLottoTicket);

        int countOfMatch = winningLottoTicket.countMatchNumber(purchasedLottoTicket);

        increaseCount(LottoRank.valueOf(countOfMatch));
    }

    public Map<LottoRank, Integer> getRankCounter() {
        return Collections.unmodifiableMap(rankCounter);
    }

    public double calculateYield(final int lottoCount) {
        validateNatureNumber(lottoCount);

        int payAmount = lottoCount * PayAmount.MIN_PAY_AMOUNT;
        long totalWinningMoney = calculateTotalWinningMoney();

        return Math.floor(((double) totalWinningMoney / payAmount) * 100) / 100.0;
    }

    private void validateNull(WinningLottoTicket winningLottoTicket, LottoTicket purchasedLottoTicket) {
        if (Objects.isNull(winningLottoTicket) || Objects.isNull(purchasedLottoTicket)) {
            throw new IllegalArgumentException(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
        }
    }

    private long calculateTotalWinningMoney() {
        long totalWinningMoney = 0;
        for (LottoRank rank : rankCounter.keySet()) {
            Integer count = rankCounter.get(rank);
            totalWinningMoney = totalWinningMoney + ((long) rank.getWinningMoney() * count);
        }
        return totalWinningMoney;
    }

    private void increaseCount(LottoRank rank) {
        if (Objects.isNull(rank)) {
            return;
        }

        int count = rankCounter.get(rank);
        rankCounter.put(rank, count + 1);
    }

    private void validateNatureNumber(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException(LottoWinningResultErrorCode.LOTTO_COUNT_ALLOW_BIGGER_THAN_ZERO.getMessage());
        }
    }
}
