package lotto.domain;

public class WinningBalls {
    private final LottoBalls winLottoBalls;
    private final LottoBall bonusBall;

    public WinningBalls(LottoBalls winLottoBalls, LottoBall bonusBall) {
        this.winLottoBalls = winLottoBalls;
        this.bonusBall = bonusBall;
    }

    public Ranking calculateRanking(LottoBalls drawBalls) {
        int count = drawBalls.countContainingWinNumbers(winLottoBalls);
        return Ranking.find(count, drawBalls.hasBonusBall(bonusBall));
    }
}
