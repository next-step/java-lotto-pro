package lotto.view;

import lotto.domain.Rank;

public class OutputConsole {

    private OutputConsole() {
    }

    public static void out(String message) {
        System.out.println(message);
    }

    public static void purchaseResult(int manuallyLottoCount, int autoLottoCount) {
        if (manuallyLottoCount != 0) {
            System.out.print(String.format("수동으로 %d장, ", manuallyLottoCount));
        }
        System.out.println(String.format("자동으로 %d개를 구매했습니다.", autoLottoCount));
    }

    public static void statistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningCount(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개", rank.getMatchCount(), rank.getMoney(), count));
            return;
        }
        System.out.println(String.format("%d개 일치 (%d원)- %d개", rank.getMatchCount(), rank.getMoney(), count));
    }

    public static void rateOfReturn(double rate) {
        System.out.print("총 수익률은 " + rate + "입니다.");
        if (rate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }
}
