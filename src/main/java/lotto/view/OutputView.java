package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoNumber;
import lotto.domain.Number;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printPurchaseLottoList(List<LottoNumber> lotto, int size) {
        if (size > 0) {
            System.out.println("수동으로 " + size + "장, "
                    + "자동으로 " + (lotto.size() - size) + "장 을 구매했습니다."
            );
        }
        for (LottoNumber lottoNumber : lotto) {
            printLottoNumbers(lottoNumber);
        }
    }

    public void printLottoNumbers(LottoNumber lottoNumber) {
        System.out.println("[" +
                String.join(",", lottoNumber.getLottoNumbers()
                        .stream()
                        .map(Number::getNumber)
                        .map(String::valueOf)
                        .collect(Collectors.toList()))
                + "]");
    }

    public void printPrizeLotto(LottoResult matchLottoResultList) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (Rank rank : Rank.values()) {
            int matchRankCount = matchLottoResultList.getMatchRankCount(rank);
            printMatchResult(rank, matchRankCount);
        }
        printLottoYield(matchLottoResultList.getLottoYield());
    }

    private void printLottoYield(double lottoYield) {
        System.out.println(
                "총 수익률은 " + lottoYield + "입니다."
                        + (lottoYield < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "")
        );
    }

    private void printMatchResult(Rank rank, int matchRankCount) {
        if (!rank.isRankMatch(Rank.NONE)) {
            System.out.println(
                    rank.getMatchCount() + "개 일치 "
                            + "(" + rank.getPrizeMoney().getMoney() + ")"
                            + "- " + matchRankCount + "개"
            );
        }
    }

}
