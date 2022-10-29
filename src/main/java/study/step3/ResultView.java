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
}
