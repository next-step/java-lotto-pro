package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.strategy.LottoGenerateStrategy;

public class BuyingLottoGroup {
    private List<Lotto> lottos;

    public static BuyingLottoGroup create(int count, LottoGenerateStrategy lottoGenerateStrategy) {
        return create(count, lottoGenerateStrategy, Collections.emptyList());
    }

    public static BuyingLottoGroup create(int count, LottoGenerateStrategy lottoGenerateStrategy, List<Lotto> manualLottos) {
        BuyingLottoGroup buyingLottoGroup = new BuyingLottoGroup();
        buyingLottoGroup.lottos = new ArrayList<>(manualLottos);

        for (int i = 0; i < count; i++) {
            buyingLottoGroup.lottos.add(lottoGenerateStrategy.generateLotto());
        }
        return buyingLottoGroup;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoResult matchWinningLotto(WinningLotto winning) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : this.lottos) {
            result.addLottoResult(winning.getLottoRank(lotto));
        }
        return result;
    }
}
