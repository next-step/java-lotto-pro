package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoGameResultDTO;
import lotto.number.LottoNumbers;
import lotto.rank.LottoRank;

public class ConsoleResultView implements ResultView {

    @Override
    public void printBoughtLottos(List<LottoNumbers> lottoNumbersList) {
        System.out.println(lottoNumbersList.size() + "개를 구매했습니다.");
        for (LottoNumbers LottoNumbers : lottoNumbersList) {
            System.out.println(LottoNumbers);
        }
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    @Override
    public void printGameResult(LottoGameResultDTO gameResult) {
        printGameResultHeader();
        printStatistics(gameResult);
        printYield(gameResult);
        printBlankLine();
    }

    private void printGameResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printStatistics(LottoGameResultDTO gameResult) {
        Map<LottoRank, Integer> statistics = gameResult.getStatistics();
        for (LottoRank rank : statistics.keySet()) {
            System.out.format("%d개 일치 (%d원)- %d개\n", rank.getMatchNumberCount(), rank.calculatePrize(1),
                    statistics.get(rank));
        }

    }

    private void printYield(LottoGameResultDTO gameResult) {
        System.out.format("총 수익률은 %.2f입니다.\n", gameResult.getYield());
    }
}
