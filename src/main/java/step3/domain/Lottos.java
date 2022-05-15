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
            int matchCount = lotto.match(winnerNumbers);
            Ranking ranking = Ranking.findRanking(matchCount);
            lottoResult.update(ranking);
        });
        return lottoResult;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        lottos.forEach(lotto -> stringBuffer.append(lotto.toString()).append("\n"));
        return stringBuffer.toString();
    }
}
