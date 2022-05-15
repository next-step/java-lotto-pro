package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {
    private final LottoGenerator generator;

    public LottoVendingMachine(final LottoGenerator generator) {
        this.generator = generator;
    }

    public LottoPaper issued(final LottoMoney money) {
        return new LottoPaper(buyLotto(money));
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
