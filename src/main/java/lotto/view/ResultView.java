package lotto.view;

import java.util.*;
import java.util.stream.*;

import lotto.domain.number.*;
import lotto.domain.result.*;
import lotto.dto.*;

public class ResultView {
    private static final String BUY_NUMBER_OF_TICKETS_STATEMENT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_STATEMENT = "당첨 통계";
    private static final String DASH_SEPARATOR = "---------";
    private static final String STATISTICS_DETAIL_STATEMENT = "%d개 일치 (%d원)- %d개";
    private static final String STATISTICS_SECOND_DETAIL_STATEMENT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String RETURN_OF_INVESTMENT_STATEMENT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static void outputTicket(LottoNumbersDto lottoNumbersDto) {
        System.out.println(lottoNumbersDto.getLottoNumbersDto()
            .stream()
            .sorted()
            .collect(Collectors.toList()));
    }

    private void outputBuyTickets(int size) {
        System.out.printf(BUY_NUMBER_OF_TICKETS_STATEMENT, size);
        System.out.print(System.lineSeparator());
    }

    public void outputTickets(List<LottoNumbersDto> lottoNumbersDtos) {
        outputBuyTickets(lottoNumbersDtos.size());
        lottoNumbersDtos
            .forEach(ResultView::outputTicket);
        System.out.print(System.lineSeparator());
    }

    public void outputStatistics(Result result, Payment payment) {
        System.out.print(System.lineSeparator());
        System.out.println(WINNING_STATISTICS_STATEMENT);
        System.out.println(DASH_SEPARATOR);

        Map<Rank, Integer> resultMap = result.result();
        Rank.ranks()
            .stream()
            .sorted(Comparator.reverseOrder())
            .forEach(rank -> outputStatisticsDetails(rank, resultMap.get(rank)));
        outputReturnOfInvestment(result.earningsRate(payment));
    }

    private void outputStatisticsDetails(Rank rank, int count) {
        String statisticsDetailString = STATISTICS_DETAIL_STATEMENT;
        if (rank.equals(Rank.SECOND)) {
            statisticsDetailString = STATISTICS_SECOND_DETAIL_STATEMENT;
        }
        System.out.printf(statisticsDetailString, rank.matchCount(), rank.money(), count);
        System.out.print(System.lineSeparator());
    }

    private void outputReturnOfInvestment(float returnOfInvestment) {
        System.out.printf(RETURN_OF_INVESTMENT_STATEMENT, returnOfInvestment);
    }

}
