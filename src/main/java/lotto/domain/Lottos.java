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
            lottos.add(new Lotto(Arrays.asList(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                    , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))); // TODO 테스트를 위해 임시로 하드코딩(generator 사용 필요)
        }
        this.lottos = lottos;
    }

    public Money findTotalPrice() {
        return new Money(lottos.size() * LOTTO_PRICE);
    }
}
