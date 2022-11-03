package lotto.domain.buyer;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;

import java.util.List;

public class LottoBuyer {

    private final Money money;

    public LottoBuyer(Money money) {
        this.money = money;
    }

    public Lottos buyAutoAndManualLotto(List<String> lottoNumbers) {
        int lottoQuantity = LottoSeller.possibleBuyLottoQuantity(money);
        List<Lotto> manual = LottoSeller.sellManualLotto(lottoNumbers);
        List<Lotto> lottos = LottoSeller.sellAutoLotto(possibleAutoLottoQuantity(manual, lottoQuantity));
        return new Lottos(lottos, manual);
    }

    private int possibleAutoLottoQuantity(List<Lotto> manualLotto, int lottoQuantity) {
        return lottoQuantity - manualLotto.size();
    }

}
