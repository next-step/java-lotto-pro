package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int maxLottoCount = money.maxLottoCount();
        for(int i = 0; i < maxLottoCount; i++) {
            lottos.add(Lotto.generateLotto(new RandomLottoNumberGenerator()));
        }
        this.lottos = lottos;
    }

    public Money findTotalPrice() {
        return new Money(lottos.size() * LOTTO_PRICE);
    }
}
