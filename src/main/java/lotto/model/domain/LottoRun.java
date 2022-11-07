package lotto.model.domain;

public class LottoRun {

    public static double calculateProfit(long buyAmount, long winAmount) {
        return Math.floor(winAmount * 1.0 / buyAmount * 100) / 100.0;
    }
}
