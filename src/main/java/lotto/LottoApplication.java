package lotto;

import java.util.List;
import lotto.domain.lotto.DefaultRandomNumberGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.NumberPickStrategy;
import lotto.domain.lotto.QuickPickStrategy;
import lotto.ui.BuyLottoView;
import lotto.ui.dto.BuyLottoInput;
import lotto.ui.dto.BuyLottoOutput;

public class LottoApplication {

    public static final int LOTTO_UNIT_PRICE = 1000;
    public static final NumberPickStrategy QUICK_PICK = new QuickPickStrategy(
            new DefaultRandomNumberGenerator());

    public static void main(String[] args) {
        final LottoStore store = new LottoStore(LOTTO_UNIT_PRICE);
        final BuyLottoInput buyLottoInput = BuyLottoView.buyLotto();
        final List<Lotto> lottos = store.buyLottos(buyLottoInput.toMoney(), QUICK_PICK);
        BuyLottoView.printLottos(new BuyLottoOutput(lottos));
    }
}
