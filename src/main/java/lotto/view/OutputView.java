package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.MatchResult;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    public void printPurchaseLottoList(Lotto lotto) {
        int purchaseCount = lotto.getLottoNumbers().size();
        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            System.out.println(lottoNumber.toString());
        }
    }

    public void printPrizeLotto(MatchResult lottoMatch) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        HashMap<Rank, Integer> matchResult = lottoMatch.getMatchResult();
        for (Map.Entry<Rank, Integer> entry : matchResult.entrySet()) {
            printMatchResult(entry);
        }
    }

    private void printMatchResult(Map.Entry<Rank, Integer> entry) {
        if (!entry.getKey().equals(Rank.NONE)) {
            System.out.println(
                    entry.getKey().getMatchCount() + "개 일치 "
                            + "(" + entry.getKey().getPrizeMoney() + ")- "
                            + entry.getValue() + "개"
            );
        }
    }

}
