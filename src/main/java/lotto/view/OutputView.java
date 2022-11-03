package lotto.view;

import java.util.Map;
import lotto.domain.Rank;

public class OutputView {
    private static final String STR_START_LOTTO = "구입금액을 입력해 주세요.";
    private static final String STR_WINNING_LOTTO_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String STR_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String STR_BUY_LOTTO = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";
    private static final String STR_BUY_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String STR_BUY_MANUAL = "수동으로 구매할 번호를 입력해 주세요.";
    
    private static final String STR_RESULT_TITLE = "당첨 통계\n";
    private static final String STR_RESULT_SEPARATOR = "---------\n";
    private static final String STR_RESULT_PRIZES = "%s - %s개\n";
    private static final String STR_RESULT_RETURN_RATE = "총 수익률은 %.2f입니다.";
    private static final String STR_RESULT_RETURN_RATE_UNDER_1 = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    
    public static void print(String str) {
        System.out.println(str);
    }
    
    public static void startLottoOutput() {
        print(STR_START_LOTTO);
    }
    
    public static void printHowManyManualTickets() {
        print(STR_BUY_MANUAL_COUNT);
    }
    
    public static void printBuyManualTickets() {
        print(STR_BUY_MANUAL);
    }
    
    public static void printHowManyTicketsPurchased(int manualTicketCount, int autoTicketCount) {
        print(String.format(STR_BUY_LOTTO, manualTicketCount, autoTicketCount));
    }

    public static void printWinningLottoNumOutput() {
        print(STR_WINNING_LOTTO_NUM);
    }
    
    public static void printBonusNumOutput() {
        print(STR_BONUS_BALL);
    }
    
    public static void printResultOutput(Map<Rank, Integer> winningMap, double returnRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(STR_RESULT_TITLE);
        sb.append(STR_RESULT_SEPARATOR);
        
        winningMap.keySet().stream().forEach(r -> {
            String formattedString = String.format(STR_RESULT_PRIZES, r.getPrizeString(), winningMap.get(r));
            sb.append(formattedString);
        });

        sb.append(String.format(STR_RESULT_RETURN_RATE, returnRate));
        
        if (returnRate < 1) {
            sb.append(STR_RESULT_RETURN_RATE_UNDER_1);
        }
        
        print(sb.toString());
    }
}
