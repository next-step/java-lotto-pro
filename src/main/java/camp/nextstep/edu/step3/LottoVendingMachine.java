package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoVendingMachine {
    private final LottoGenerator generator;

    public LottoVendingMachine(final LottoGenerator generator) {
        this.generator = generator;
    }

    public LottoPaper issued(final LottoMoney money) {
        return new LottoPaper(buyLotto(money));
    }

    public LottoPaper issued(final LottoMoney money, List<Lotto> manualLotto) {
        if (Objects.isNull(manualLotto) || manualLotto.isEmpty()) {
            return this.issued(money);
        }
        return issuedManualWithAuto(money, manualLotto);
    }

    private LottoPaper issuedManualWithAuto(LottoMoney money, List<Lotto> manualLotto) {
        List<Lotto> automaticallyIssuedLotto = buyLotto(money.excludingAmount(manualLotto));
        List<Lotto> totalLotto = new ArrayList<>();
        totalLotto.addAll(manualLotto);
        totalLotto.addAll(automaticallyIssuedLotto);
        return new LottoPaper(totalLotto);
    }

    private List<Lotto> buyLotto(LottoMoney money) {
        return extractLottoByAuto(money);
    }

    private List<Lotto> extractLottoByAuto(LottoMoney money) {
        List<Lotto> lottoList = new ArrayList<>();
        while (money.isBuyable()) {
            money = money.buy();
            lottoList.add(generator.auto());
        }
        return lottoList;
    }
}
