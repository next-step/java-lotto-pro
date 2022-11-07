package step3.model;

import step3.service.LottoScoreType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        if (lotto == null) {
            return;
        }

        this.lottos.add(lotto);
    }

    public int count() {
        return lottos.size();
    }

    public void print(Consumer<String> consumer) {
        this.lottos.forEach(lotto -> consumer.accept(lotto.toString()));
    }

    public List<LottoScoreType> confirmLottoWinningNumber(LottoWinningNumber winningLotto) {
        List<LottoScoreType> scoreTypes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.getMatchedCount(winningLotto);
            boolean matchedBonus = lotto.isMatchedBonus(winningLotto);
            LottoScoreType lottoScoreType = LottoScoreType.getByScore(matchedCount, matchedBonus);
            addLottoScoreType(scoreTypes, lottoScoreType);
        }

        return scoreTypes;
    }

    private void addLottoScoreType(List<LottoScoreType> scoreTypes, LottoScoreType lottoScoreType) {
        if (lottoScoreType != null) {
            scoreTypes.add(lottoScoreType);
        }
    }
}
