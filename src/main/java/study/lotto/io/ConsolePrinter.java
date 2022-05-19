package study.lotto.io;

import java.util.List;
import study.lotto.Lotto;
import study.lotto.LottoResultMap;
import study.lotto.enumtype.LottoRank;

public class ConsolePrinter implements Printer {
    private static final String SPACE_STRING = " ";
    private static final String SECOND_ADDITIONAL_STRING = ", 보너스 볼 일치";

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

        print(lottoResultMap, LottoRank.FIFTH);
        print(lottoResultMap, LottoRank.FOURTH);
        print(lottoResultMap, LottoRank.THIRD);
        print(lottoResultMap, LottoRank.SECOND, SECOND_ADDITIONAL_STRING);
        print(lottoResultMap, LottoRank.FIRST);

        System.out.printf("총 수익률은 %.2f입니다.%n", lottoResultMap.calcLottoYield());
    }

    private void print(LottoResultMap lottoResultMap, LottoRank winningType, String additionalString) {
        System.out.printf("%d개 일치%s(%d원)- %d개%n", winningType.getMatchCount(),
                additionalString,
                winningType.getWinnings(),
                lottoResultMap.matchCount(winningType));
    }

    private void print(LottoResultMap lottoResultMap, LottoRank winningType) {
        print(lottoResultMap, winningType, SPACE_STRING);
    }
}
