import java.util.Arrays;
import java.util.Comparator;

public class ResultView {

    private ResultView() {
    }

    public static void printBuyResult(int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualCount, autoCount);
    }

    public static void printLottoList(Lottos lottoList) {
        printBuyResult(lottoList.getManualCount(), lottoList.getAutoCount());
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i));
        }
    }

    public static void printResult(User user) {
        System.out.println("\n당첨 통계\n-------------");
        Arrays.stream(LottoReward.values())
                .sorted(Comparator.reverseOrder())
                .forEach(reward -> reward.printReward(user.getMatchLottoCount(reward)));
        System.out.printf("총 수익률은 %.2f 입니다.", user.getProfitRate());
    }

}
