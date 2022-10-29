package study.lotto.view;

import study.lotto.domain.*;

import java.util.Map;

public class LottoGames {

    private final LottoInput input = new LottoInput();
    private final LottoOutput output = new LottoOutput();

    public void start() {
        Order order = order();
        Lottos lottos = new Lottos(Store.buy(order.getQuantity()));
        printLottos(lottos);
        printWinStats(lottos.drawLots(inputWinningNumbers()));
    }

    private Order order() {
        output.printMessage("구입금액을 입력해 주세요.");
        Order order = input.inputQuantity();
        output.printMessage(order.getQuantity() + "개를 구매했습니다.");
        return order;
    }

    private void printLottos(Lottos lottos) {
        output.printMessage(lottos.toString());
    }

    private WinningLotto inputWinningNumbers() {
        output.printMessage("\n지난 주 당첨 번호를 입력해 주세요.");
        return input.inputWinningNumbers();
    }

    private void printWinStats(WinStats stats) {
        Map<LottoStatus, Long> printData = stats.getPrintDataWithCountsByLottoStatus();
        output.printMessage("당첨 통계");
        output.printMessage("---------");
        output.printMessage("3개 일치 (5000원) - " + printData.get(LottoStatus.FOURTH_PLACE));
        output.printMessage("4개 일치 (50000원) - " + printData.get(LottoStatus.THIRD_PLACE));
        output.printMessage("5개 일치 (1500000원) - " + printData.get(LottoStatus.SECOND_PLACE));
        output.printMessage("6개 일치 (2000000000원) - " + printData.get(LottoStatus.FIRST_PLACE));
        output.printMessage("총 수익률은 " + stats.getPrintDataWithProfitRate() + "입니다.");
    }

}
