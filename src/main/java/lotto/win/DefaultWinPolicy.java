package lotto.win;

public class DefaultWinPolicy implements WinPolicy {

    @Override
    public boolean isWin(int matchCount) {
        return WinRanking.isWin(matchCount);
    }
}
