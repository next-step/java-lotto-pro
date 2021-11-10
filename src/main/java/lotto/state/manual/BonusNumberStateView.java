package lotto.state.manual;

import lotto.domain.Rank;
import lotto.domain.Record;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BonusNumberStateView {
    private static final List<Rank> RANKS = Arrays.asList(Rank.FIRST, Rank.SECOND_WITH_BONUS, Rank.SECOND, Rank.THIRD, Rank.FOURTH);

    public void printQuestion(PrintStream out) {
        out.println("보너스 볼을 입력해 주세요.");
    }

    public void printResult(PrintStream out, Record record) {
        out.println("당첨 통계");
        out.println("---------");
        for (Rank rank : RANKS) {
            printRank(out, record, rank);
        }
        out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", record.getProfitRate());
    }

    private void printRank(PrintStream out, Record record, Rank rank) {
        String message = "%d개 일치 (%s원)- %d개%n";
        if (rank == Rank.SECOND_WITH_BONUS) {
            message = "%d개 일치, 보너스 볼 일치(%s원)- %d개%n";
        }
        out.printf(message, rank.getMatchingCount(), rank.getWinningMoney(), rank.getCount(record));
    }
}
