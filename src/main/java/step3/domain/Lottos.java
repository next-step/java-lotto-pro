package step3.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult allMatch(List<Integer> winnerNumbers) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> {
            int matchCount = lotto.match(new WinnerLotto(winnerNumbers));
            Ranking ranking = Ranking.findRanking(matchCount);
            lottoResult.updateHitRanking(ranking);
        });
        return lottoResult;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
