package study.lotto.io;

import java.util.List;
import study.lotto.Lotto;
import study.lotto.LottoResultMap;
import study.lotto.enumtype.LottoWinningType;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printMyLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    @Override
    public void printResult(LottoResultMap lottoResultMap) {
        System.out.println("당첨통계");
        System.out.println("---------");

        print(lottoResultMap, LottoWinningType.MATCH_COUNT_3);
        print(lottoResultMap, LottoWinningType.MATCH_COUNT_4);
        print(lottoResultMap, LottoWinningType.MATCH_COUNT_5);
        print(lottoResultMap, LottoWinningType.MATCH_COUNT_6);

        System.out.printf("총 수익률은 %.2f입니다.%n", lottoResultMap.calcLottoYield());
    }

    private void print(LottoResultMap lottoResultMap, LottoWinningType winningType) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", winningType.getMatchCount(),
                winningType.getWinnings(),
                lottoResultMap.matchCount(winningType));
    }
}
