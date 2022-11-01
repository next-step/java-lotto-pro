package study.lotto;

import study.lotto.domain.*;
import study.lotto.domain.order.UserOrder;
import study.lotto.view.LottoInput;
import study.lotto.view.LottoOutput;
import study.splitter.Splitter;

import java.util.Map;

public class LottoGames {

    private static final int MANUAL_ORDER_MIN = 1;

    private final LottoInput input = new LottoInput();
    private final LottoOutput output = new LottoOutput();

    public void start() {
        Lottos lottos = order();
        printLottos(lottos);

        WinningLotto winningLotto = inputWinningNumbers();
        inputBonusBall(winningLotto);

        printWinStats(lottos.drawLots(winningLotto));
    }

    private Lottos order() {
        output.printMessage("구입금액을 입력해 주세요.");
        UserOrder userOrder = input.inputUserPurchase();

        output.printMessage("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualQuantity = input.inputManualQuantity(userOrder);
        userOrder.prepareOrder(manualQuantity);
        inputManualLottos(manualQuantity, userOrder);

        Lottos lottos = userOrder.order();
        printOrderResult(userOrder.toString());

        return lottos;
    }

    private void inputManualLottos(int manualQuantity, UserOrder userOrder) {
        if(manualQuantity >= MANUAL_ORDER_MIN) {
            output.printMessage("수동으로 구매할 번호를 입력해 주세요.");
            input.inputManualLottos(manualQuantity, userOrder);
        }
    }

    private void printOrderResult(String orderResult) {
        String[] orderMsg = Splitter.split(orderResult);
        output.printMessage("수동으로 " + orderMsg[0] + "개, 자동으로 " + orderMsg[1] + "개를 구매했습니다.");
    }

    private void printLottos(Lottos lottos) {
        output.printMessage(lottos.toString());
    }

    private WinningLotto inputWinningNumbers() {
        output.printMessage("\n지난 주 당첨 번호를 입력해 주세요.");
        return input.inputWinningNumbers();
    }

    private void inputBonusBall(WinningLotto winningLotto) {
        output.printMessage("보너스 볼을 입력해 주세요.");
        input.inputBonusBall(winningLotto);
    }

    private void printWinStats(WinStats stats) {
        Map<LottoStatus, Long> printData = stats.getPrintDataWithCountsByLottoStatus();

        output.printMessage("당첨 통계");
        output.printMessage("---------");
        output.printMessage("3개 일치 (5000원) - " + printData.get(LottoStatus.FIFTH_PLACE));
        output.printMessage("4개 일치 (50000원) - " + printData.get(LottoStatus.FOURTH_PLACE));
        output.printMessage("5개 일치 (1500000원) - " + printData.get(LottoStatus.THIRD_PLACE));
        output.printMessage("5개 일치, 보너스 볼 일치(30000000원) - " +
                printData.get(LottoStatus.SECOND_PLACE));
        output.printMessage("6개 일치 (2000000000원) - " + printData.get(LottoStatus.FIRST_PLACE));
        output.printMessage("총 수익률은 " + stats.getPrintDataWithProfitRate() + "입니다.");
    }

}
