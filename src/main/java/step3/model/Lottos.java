package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void generate(int generatorCount) {
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

    public LottoResult calculatorLotto(Lotto lastWeekLotto, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int sameCount = lotto.sameNumberCount(lastWeekLotto);
            boolean containBonus = lotto.containBonusNumber(bonusNumber);
            lottoResult.addResult(sameCount, containBonus);
        }
        return lottoResult;
    }

    public void addedLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void addedLottos(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }
}
