package lotto_auto.view;

import lotto_auto.model.*;

import java.util.stream.Collectors;

public class Output {
    public static final String MONEY_INPUT_NOTICE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";
    public static final String WINNING_LOTTO_INPUT_NOTICE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String PROFIT_RATE_NOTICE_FORMAT = "총 수익률은 %s입니다.";

    public void showMoneyInputNotice() {
        System.out.println(MONEY_INPUT_NOTICE);
    }

    public void showProfitRate(ProfitRate profitRate) {
        System.out.format(PROFIT_RATE_NOTICE_FORMAT, profitRate.printRate());
    }

    public void showPurchaseLottoCountNotice(int count) {
        System.out.format(PURCHASE_LOTTO_COUNT_FORMAT, count);
    }

    public void showPurchasedLottos(Lottos purchasedLottos) {
        String result = purchasedLottos.getLottoList()
                .stream()
                .map(Lotto::printLotto)
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    public void showWinningLottoNotice() {
        System.out.println(WINNING_LOTTO_INPUT_NOTICE);
    }

    public void showFigures(Figures figures) {
        String figuresTitle = "당첨 통계\n---------";
        System.out.println(figuresTitle);

        System.out.println(figures.printFigures());
    }

    public void showError(Throwable e) {
        System.out.println(e.getMessage());
    }
}
