package step3.view;

public class ResultView {

    public static void printLottosQuantity(int quantity) {
        System.out.printf("%d개를 구매했습니다.%n", quantity);
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
