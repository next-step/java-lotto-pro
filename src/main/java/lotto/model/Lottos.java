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

    public Map<Rank, Integer> rankCount(LottoNumbers winningNumbers) {
        Map<Rank, Integer> rankCount = new LinkedHashMap<>();
        lottos.forEach(lottoNumbers -> {
            int matchCount = lottoNumbers.matchCount(winningNumbers);
            Rank rank = Rank.getRank(matchCount);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        });
        return rankCount;
    }
}
