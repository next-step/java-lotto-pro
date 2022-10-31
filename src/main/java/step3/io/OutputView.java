package step3.io;

import java.util.Comparator;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Rank;
import step3.domain.Reward;

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
                .sorted(Comparator.comparing(Rank::getCountOfMatch)
                        .thenComparing(Rank::getWinningMoney))
                .filter(rank -> !rank.equals(Rank.MISS))
                .forEach(rank -> printStatistic(reward, rank));
    }

    private void printStatistic(Reward reward, Rank rank) {
        System.out.println(rank.getCountOfMatch()
                + "개 일치"
                + generateBonusMatchMessage(rank)
                + "("
                + rank.getWinningMoney()
                + "원)- "
                + reward.getRankCount(rank)
                + "개");
    }

    private String generateBonusMatchMessage(Rank rank) {
        if (rank.isMatchBonus()) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    public void printWinningMoneyRate(Money payment, Reward reward) {
        String winningMoneyRate = reward.getWinningMoneyRate(payment);
        String output = "총 수익률은 " + winningMoneyRate + "입니다.";
        if (Float.parseFloat(winningMoneyRate) < 1) {
            output += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.println(output);
    }
}
