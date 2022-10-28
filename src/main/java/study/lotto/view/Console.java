package study.lotto.view;

import study.lotto.domain.*;

public class Console {

    private final LottoInput input = new LottoInput();
    private final LottoOutput output = new LottoOutput();

    public void startConsole() {
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

    private WinningNumbers inputWinningNumbers() {
        output.printMessage("\n지난 주 당첨 번호를 입력해 주세요.");
        return input.inputWinningNumbers();
    }

    private void printWinStats(WinStats stats) {
        output.printMessage(stats.toString());
    }

}
