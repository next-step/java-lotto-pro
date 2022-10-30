package step3.domain.lotto;

import step3.domain.amount.Amount;

import java.util.ArrayList;
import java.util.List;

import static step3.domain.lotto.Lotto.DEFAULT_LOTTO_PRICE;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(Amount amount) {
        createLottos(amount);
    }

    private void createLottos(Amount amount) {
        for (int i = 0; i < amount.getLottoPurchasesCount(DEFAULT_LOTTO_PRICE); i++) {
            lottos.add(new Lotto(new LottoNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
