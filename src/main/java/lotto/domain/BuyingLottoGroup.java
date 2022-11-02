package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.LottoNumberStrategy;

public class BuyingLottoGroup {
    private List<Lotto> lottos = new ArrayList<>();

    public static BuyingLottoGroup create(int count, LottoNumberStrategy lottoNumberStrategy) {
        BuyingLottoGroup buyingLottoGroup = new BuyingLottoGroup();

        for (int i = 0; i < count; i++) {
            buyingLottoGroup.lottos.add(Lotto.create(lottoNumberStrategy.generateNumbers()));
        }
        return buyingLottoGroup;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult matchWinningLotto(WinningLotto winning) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : this.lottos) {
            result.addLottoResult(winning.getLottoRank(lotto));
        }
        return result;
    }
}
