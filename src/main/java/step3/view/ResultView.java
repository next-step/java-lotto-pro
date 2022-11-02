package step3.view;

public class ResultView {

    public static void printLottosQuantity(long manual, long automatic) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manual, automatic);
    }

    public static void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public static void printResult(String lottoStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("------------");
        System.out.println(lottoStatistics);
    }

    public static void printTotalProfit(double totalProfit) {
        System.out.printf("총 수익률은 %.2f입니다.%n", totalProfit);
    }
}
