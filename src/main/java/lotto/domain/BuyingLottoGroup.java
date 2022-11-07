package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.strategy.LottoNumberStrategy;

public class BuyingLottoGroup {
    private List<Lotto> lottos;

    public static BuyingLottoGroup create(int count, LottoNumberStrategy lottoNumberStrategy) {
        return create(count, lottoNumberStrategy, Collections.emptyList());
    }

    public static BuyingLottoGroup create(int count, LottoNumberStrategy lottoNumberStrategy, List<Lotto> manualLottos) {
        BuyingLottoGroup buyingLottoGroup = new BuyingLottoGroup();
        buyingLottoGroup.lottos = new ArrayList<>(manualLottos);

        for (int i = 0; i < count; i++) {
            buyingLottoGroup.lottos.add(Lotto.create(lottoNumberStrategy.generateNumbers()));
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
