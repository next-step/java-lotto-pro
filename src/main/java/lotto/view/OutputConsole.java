package lotto.view;

import lotto.domain.Rank;

public class OutputConsole {

    private OutputConsole() {
    }

    public static void out(String message) {
        System.out.println(message);
    }

    public static void purchaseResult(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public static void statistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningCount(Rank rank, int count) {
        System.out.println(String.format(rank.toString() + "- %d", count));
    }

    public static void rateOfReturn(double rate) {
        System.out.print("총 수익률은 " + rate + "입니다.");
        if (rate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }
}
