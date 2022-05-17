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
        printBlankLine();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printStatistics(LottoGameResultDTO gameResult) {
        Map<LottoRank, Long> statistics = gameResult.getStatistics();
        for (LottoRank rank : statistics.keySet()) {
            printRankResult(rank, statistics.get(rank));
        }
    }
    private void printRankResult(LottoRank rank, long matchCount) {
        if(rank == LottoRank.SECOND_PLACE){
            System.out.format("%d개 일치, 보너스 볼 일치(%d원)- %d개\n"
                    , rank.getMatchNumberCount()
                    , rank.calculatePrize(1),
                    matchCount);
            return;
        }
        System.out.format("%d개 일치 (%d원)- %d개\n"
                , rank.getMatchNumberCount()
                , rank.calculatePrize(1),
                matchCount);
    }
    private void printYield(LottoGameResultDTO gameResult) {
        System.out.format("총 수익률은 %.2f입니다.\n", gameResult.getYield());
    }
}
