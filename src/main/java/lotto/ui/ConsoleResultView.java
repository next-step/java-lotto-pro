package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winnings;

import java.util.Map;

public class ConsoleResultView implements ResultView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_ACK_MESSAGE = "%d개를 구매했습니다.";
    private static final String WIN_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WIN_STATISTIC_ALARM_MESSAGE = "당첨 통계\n---------";
    private static final String CORRESPOND_LOTTO_NUMBERS_MESSAGE = "%d개 일치(%d원) - %d개";
    private static final String TOTAL_REVENUE_MESSAGE = "총 수익률 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    @Override
    public void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    @Override
    public void printPurchaseAckMessage(int count) {
        System.out.println(String.format(PURCHASE_ACK_MESSAGE, count));
    }

    @Override
    public void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos)
        {
            System.out.println(lotto);
        }
    }

    @Override
    public void printLastWinLottoNumbersMessage() {
        System.out.println(WIN_LOTTO_NUMBERS_MESSAGE);
    }

    @Override
    public void printWinStatisticMessage() {
        System.out.println(WIN_STATISTIC_ALARM_MESSAGE);
    }

    @Override
    public void printCorrespondLottoNumber(Map<Winnings, Integer> statistic) {
        statistic.entrySet().stream()
                .filter(e -> !e.getKey().equals(Winnings.MISS))
                .map(e -> String.format(CORRESPOND_LOTTO_NUMBERS_MESSAGE ,e.getKey().getCorrespondCount(), e.getKey().getAmount(), e.getValue()))
                .forEach(System.out::println);
    }

    @Override
    public void printTotalRevenueMessage(double percentage) {
        System.out.println(String.format(TOTAL_REVENUE_MESSAGE, percentage));
    }

    @Override
    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
}
