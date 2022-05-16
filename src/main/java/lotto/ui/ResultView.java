package lotto.ui;

import java.util.Map;

public class ResultView {
    public static void printTicketCount(int purchasePrice) {
        System.out.println(String.format("%d개를 구매했습니다.", purchasePrice));
    }

    public static void printTicketLottoNumbers(String ticketLottoNumbers) {
        System.out.println(ticketLottoNumbers);
    }

    public static void printGameResult(Map<Integer, Integer> score, double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("3개 일치 (5000원)- %d개", score.get(3)));
        System.out.println(String.format("4개 일치 (50000원)- %d개", score.get(4)));
        System.out.println(String.format("5개 일치 (1500000원)- %d개", score.get(5)));
        System.out.println(String.format("3개 일치 (2000000000원)- %d개", score.get(6)));
        StringBuffer earningRateMessage = new StringBuffer(String.format("총 수익률은 %.2f입니다.", earningRate));
        if (earningRate < 1) {
            earningRateMessage.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(earningRateMessage);
    }
}
