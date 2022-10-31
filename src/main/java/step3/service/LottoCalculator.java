package step3.service;

import step3.model.Lotto;
import step3.model.LottoResult;
import step3.model.LottoResults;
import step3.model.Lottos;

import java.util.HashMap;
import java.util.Map;

public class LottoCalculator {

    public LottoResults calculate(Lotto winningLotto, Lottos lottos) {
        return calculateLuckyResult(winningLotto, lottos);
    }

    private LottoResults calculateLuckyResult(Lotto winningLotto, Lottos lottos) {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        int lottosCount = lottos.count();
        for (int index = 0 ; index < lottosCount ; index++) {
            Lotto lotto = lottos.getLottoByIndex(index);
            int matchedCount = lotto.getMatchedCountComparedToLotto(winningLotto);

            int count = lottoResult.getOrDefault(matchedCount, 0);
            lottoResult.put(matchedCount, ++count);
        }

        return generateLottoResults(lottoResult);
    }

    private LottoResults generateLottoResults(Map<Integer, Integer> lottoResult) {
        LottoResults lottoResults = new LottoResults();
        for (LottoScoreType scoreType : LottoScoreType.values()) {
            int score = scoreType.getScore();
            int scoreMatchedCount = lottoResult.getOrDefault(score, 0);
            int money = scoreType.getMoney();
            lottoResults.add(new LottoResult(score, scoreMatchedCount, money));
        }

        return lottoResults;
    }
}
