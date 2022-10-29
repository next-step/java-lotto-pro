package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public void generate(int generatorCount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < generatorCount; i++) {
            Lotto lotto = new Lotto();
            lotto.generateRandomNumber();
            lottos.add(lotto);
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult calculatorLotto(Lotto lastWeekLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            lottoResult.addResult(lotto.sameNumberCount(lastWeekLotto));
        }
        return lottoResult;
    }
}
