package lotto.domain;

public class LottosResult {
    private final int purchaseMoney;
    private long returnMoney;

    public LottosResult(int purchaseMoney, LottosWinnerCounts lottosWinnerCounts) {
        this.purchaseMoney = purchaseMoney;
        this.returnMoney = 0;
        reflectLottosWinner(lottosWinnerCounts);
    }

    private void reflectLottosWinner(LottosWinnerCounts lottosWinnerCounts) {
        for (LottoWinner winner : LottoWinner.values()) {
            int count = lottosWinnerCounts.winnerCount(winner);
            long winnerMoney = winner.getWinnerMoney() * count;
            returnMoney += winnerMoney;
        }
    }

    public float ratio() {
        return (float) returnMoney / purchaseMoney;
    }
}
