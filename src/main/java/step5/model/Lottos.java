package step5.model;

import step5.service.LottoScoreType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> manualLottos) {
        this.lottos = new ArrayList<>(manualLottos);
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

    public List<LottoScoreType> confirmLottoWinningNumber(LottoWinningNos winningLotto) {
        List<LottoScoreType> scoreTypes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchedCount = winningLotto.getMatchedCount(lotto);
            boolean matchedBonus = winningLotto.isMatchedBonus(lotto);
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
