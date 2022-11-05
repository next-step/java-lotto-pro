package study.lotto.view;

import study.lotto.domain.LottoStatus;
import study.lotto.domain.Lottos;
import study.splitter.Splitter;

import java.util.Map;

public class LottoOutput {

    private static final int MANUAL_ORDER_MIN = 1;

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printManualLottoAmountMessage() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printManualLottosMessage(int manualQuantity) {
        if(manualQuantity >= MANUAL_ORDER_MIN) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
    }

    public void printOrderResult(String orderResult) {
        String[] orderMsg = Splitter.split(orderResult);
        System.out.println("수동으로 " + orderMsg[0] + "개, 자동으로 " + orderMsg[1] + "개를 구매했습니다.");
    }

    public void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public void printWinningNumbersMessage() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printBonusBallMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printWinStats(Map<LottoStatus, Long> winStats) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winStats.get(LottoStatus.FIFTH_PLACE));
        System.out.println("4개 일치 (50000원) - " + winStats.get(LottoStatus.FOURTH_PLACE));
        System.out.println("5개 일치 (1500000원) - " + winStats.get(LottoStatus.THIRD_PLACE));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winStats.get(LottoStatus.SECOND_PLACE));
        System.out.println("6개 일치 (2000000000원) - " + winStats.get(LottoStatus.FIRST_PLACE));
    }

    public void printProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
