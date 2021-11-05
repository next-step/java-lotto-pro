package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {

    public void printPurchaseLottoList(List<LottoNumber> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (LottoNumber lottoNumber : lotto) {
            System.out.println(lottoNumber.toString());
        }
    }

    public void printPrizeLotto(Lotto matchLottoList) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (Rank rank : Rank.values()) {
            int matchRankCount = matchLottoList.getMatchRankCount(rank);
            printMatchResult(rank, matchRankCount);
        }
        printLottoYield(matchLottoList.getLottoYield());
    }

    private void printLottoYield(double lottoYield) {
        System.out.println(
                "총 수익률은 " + lottoYield + "입니다."
                        + (lottoYield < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "")
        );
    }

    private void printMatchResult(Rank rank, int matchRankCount) {
        if (!rank.isRankMatch(Rank.NONE)) {
            System.out.println(rank.toString() + matchRankCount + "개");
        }
    }

}
