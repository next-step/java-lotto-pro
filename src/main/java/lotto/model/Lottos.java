package lotto.model;

import lotto.enums.Rank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.ResultView.printLottoNumbers;

public class Lottos {
    private List<LottoNumbers> lottos;

    private Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<LottoNumbers> lottos) {
        return new Lottos(lottos);
    }

    public void printLottos() {
        for (LottoNumbers lottoNumbers : lottos) {
            printLottoNumbers(lottoNumbers);
        }
    }

    public RankCount rankCount(LottoNumbers winningNumbers) {
        Map<Rank, Integer> rankCount = initRankCount();
        lottos.forEach(lottoNumbers -> {
            int matchCount = lottoNumbers.matchCount(winningNumbers);
            System.out.println("일치횟수 : " + matchCount);

            Rank rank = Rank.getRank(matchCount);
            System.out.println("랭킹 : " + rank);

            rankCount.put(rank, rankCount.get(rank) + 1);
            System.out.println("rankCount : "+ rankCount);
        });
        return RankCount.from(rankCount);
    }

    private Map<Rank, Integer> initRankCount() {
        Map<Rank, Integer> rankCount = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            System.out.println("초기화 : " + rank);
            rankCount.put(rank, 0);
        }
        return rankCount;
    }
}
