package lotto.ui;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoRank;
import lotto.domain.LottoResultStat;

public class View {

    private static final String RESULT_BY_RANK_TEXT = "%d개 일치(%d원)- %d개";
    private static final String SECOND_RANK_RESULT_TEXT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String TOTAL_PROFIT_TEXT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_TICKET_SIZE_TEXT = "%d개를 구매했습니다.";
    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int insertMoney() {
        output.print("구입금액을 입력해 주세요.");
        return Integer.parseInt(input.nextLine());
    }

    public void printLottoSize(int size) {
        output.print(String.format(LOTTO_TICKET_SIZE_TEXT, size));
    }

    public void printText(String text) {
        output.print(text);
    }

    public List<Integer> insertWinningNumber() {
        output.print("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(input.inputNumbers())
                .map(token -> Integer.parseInt(token.trim()))
                .collect(Collectors.toList());
    }

    public void printResultStat(LottoResultStat lottoResultStat) {
        output.print("당첨 통계");
        output.print("---------");
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> !rank.equals(LottoRank.FAIL))
                .map(rank ->
                        String.format(
                                rank.equals(LottoRank.SECOND) ? SECOND_RANK_RESULT_TEXT : RESULT_BY_RANK_TEXT,
                                rank.getMatchCount(), rank.getWinningPrice(),
                                lottoResultStat.resultByRank(rank))
                )
                .forEach(output::print);
        output.print(String.format(TOTAL_PROFIT_TEXT, lottoResultStat.totalProfit()));
    }

    public int insertBonusNumber() {
        output.print("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(input.nextLine());
    }
}
