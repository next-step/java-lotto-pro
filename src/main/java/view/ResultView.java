package view;

import static domain.LottoWinning.NONE;

import domain.LottoResult;
import domain.LottoWinning;
import domain.Lottos;

import java.util.Arrays;

public class ResultView {
    public static void printLottoResult(LottoResult lottoResult) {
        printLottoResultPrefix();
        printWinningResult(lottoResult);
        printEarningRate(lottoResult.earningRate());
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다\n", lottos.size());
        lottos.getLottos().forEach(System.out::println);
        System.out.print("\n");
    }

    private static void printLottoResultPrefix() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printWinningResult(LottoResult lottoResult) {
        Arrays.stream(LottoWinning.values())
            .filter(lottoWinning -> !lottoWinning.equals(NONE))
            .forEach(lottoWinning -> System.out.printf(ResultMessage.getMessage(lottoWinning),
                lottoWinning.getMaxNumberMatched(),
                lottoWinning.getPrize(),
                lottoResult.countOfMatch(lottoWinning)));
    }

    private static void printEarningRate(float earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
            earningRate);
    }

    enum ResultMessage {
        FIRST_PRIZE(LottoWinning.FIRST_PRIZE, "%d개 일치 (%d원)- %d개\n"),
        SECOND_PRIZE(LottoWinning.SECOND_PRIZE, "%d개 일치, 보너스 볼 일치(%d원)- %d개\n"),
        THIRD_PRIZE(LottoWinning.THIRD_PRIZE, "%d개 일치 (%d원)- %d개\n"),
        FOURTH_PRIZE(LottoWinning.FOURTH_PRIZE, "%d개 일치 (%d원)- %d개\n"),
        FIFTH_PRIZE(LottoWinning.FIFTH_PRIZE, "%d개 일치 (%d원)- %d개\n"),
        NONE(LottoWinning.NONE, "%d개 일치 (%d원)- %d개\n"),
        ;

        private final LottoWinning lottoWinning;
        private final String message;

        ResultMessage(LottoWinning lottoWinning, String message) {
            this.lottoWinning = lottoWinning;
            this.message = message;
        }

        public static String getMessage(LottoWinning lottoWinning) {
            return valueOf(lottoWinning.name()).getMessage();
        }

        public String getMessage() {
            return message;
        }
    }
}
