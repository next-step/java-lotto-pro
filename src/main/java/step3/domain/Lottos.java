package step3.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult allMatch(List<Integer> winnerNumbers, int bonusNumber) {
        WinnerLotto winnerLotto = new WinnerLotto(winnerNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> {
            Ranking ranking = winnerLotto.matchRanking(lotto);
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
