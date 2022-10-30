package step3_4.io;

import java.util.Comparator;
import step3_4.domain.Lottos;
import step3_4.domain.Money;
import step3_4.domain.Rank;
import step3_4.domain.Reward;

public class OutputView {

    public void printPurchaseCount(Money payment, Money pricePerLotto) {
        System.out.println(payment.divide(pricePerLotto) + "개를 구매했습니다.");
    }

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printStatistics(Reward reward) {
        reward.getKeySet()
                .stream()
                .sorted(Comparator.comparing(Rank::getCountOfMatch))
                .filter(rank -> !rank.equals(Rank.MISS))
                .forEach(rank -> printStatistic(reward, rank));
    }

    private void printStatistic(Reward reward, Rank rank) {
        System.out.println(rank.getCountOfMatch()
                + "개 일치 ("
                + rank.getWinningMoney()
                + "원)- "
                + reward.getRankCount(rank)
                + "개");
    }

    public void printWinningMoneyRate(Money payment, Reward reward) {
        String winningMoneyRate = reward.getWinningMoneyRate(payment);
        System.out.println("총 수익률은 " + winningMoneyRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
