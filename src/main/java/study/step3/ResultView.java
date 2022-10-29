package study.step3;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.\n", lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printLottoWinners(Winners winners) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Prize prize : Prize.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n"
                    , prize.getWinNumber()
                    , prize.getReward()
                    , winners.nThPrizeSize(prize.getWinNumber()));
        }
    }

    public static void printEarningRate(Winners winners, int money) {
        System.out.println(
                String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
                        , winners.earningRate(money)));
    }
}
