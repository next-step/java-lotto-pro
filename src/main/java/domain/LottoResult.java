package domain;

public class LottoResult {
    private final Lottos lottos;
    private final WinningResult winningResult;

    public static LottoResult of(Lottos lottos, WinningNumber winningNumber) {
        return new LottoResult(lottos, winningNumber);
    }

    private LottoResult(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningResult = lottos.winningResult(winningNumber);
    }

    public int countOfMatch(LottoWinning lottoWinning) {
        return winningResult.countOfMatch(lottoWinning);
    }

    public float earningRate() {
        return totalPrize() / spentMoney();
    }

    private int totalPrize() {
        return winningResult.totalPrize();
    }

    private float spentMoney() {
        return lottos.spentMoney();
    }
}
