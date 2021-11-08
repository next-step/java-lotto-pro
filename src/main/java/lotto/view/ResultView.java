package lotto.view;

import lotto.domain.Money;

public class ResultView {

    public static final int BEP = 1;

    public ResultView() {
    }

    public void printBuyResult(int count, String toResultString) {
        System.out.println(count + "개를 구매했습니다.");
        System.out.println(toResultString);
    }

    public void printGameResult(String resultString) {
        System.out.println(resultString);
    }

    public void printEarningRatio(Money inputMoney, Money prize) {
        double earningRatio = (double) prize.get() / inputMoney.get();
        String result = "총 수익률은 " + earningRatio + "입니다. ";
        if (earningRatio < BEP) {
            result += "기준이 1이기 때문에 결과적으로 손해라는 의미임";
        }
        System.out.print(result);
    }
}
