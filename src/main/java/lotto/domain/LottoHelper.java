package lotto.domain;

public class LottoHelper {

    public static final int LOTTO_PER_PRICE = 1000;

    public static int countPurchasableLotto(int amount) {
        return amount / LOTTO_PER_PRICE;
    }

    public static double getRateOfReturn(int purchaseCount, int winningAmount) {
        return (double) winningAmount / (purchaseCount * LOTTO_PER_PRICE);
    }

    public static int countWinningNumber(LottoNumbers winningLottoNumbers, LottoNumbers myLottoNumbers) {
        int winningCount = 0;
        for (LottoNumber winningNumber : winningLottoNumbers.getLottoNumbers()) {
            winningCount += checkContainsNumber(myLottoNumbers, winningCount, winningNumber);
        }
        return winningCount;
    }

    private static int checkContainsNumber(LottoNumbers myLottoNumbers, int winningCount, LottoNumber winningNumber) {
        if (myLottoNumbers.containsNumber(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
