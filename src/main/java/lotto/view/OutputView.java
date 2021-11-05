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
    }

    private void printMatchResult(Rank rank, int matchRankCount) {
        if (!rank.isRankMatch(Rank.NONE)) {
            System.out.println(rank.toString() + matchRankCount + "개");
        }
    }

}
