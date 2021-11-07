package lotto.view;

import lotto.model.Lottos;

public class InputView {

    public void showEnterBuyMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoBoughtMessage(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.print();
    }

    public void showEnterWinNumbersMessage() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
    }
}
