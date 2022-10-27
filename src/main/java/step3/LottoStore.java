package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int PRICE_PER_LOTTO = 1000;

    public Lottos purchase(long price) {
        if (price < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("You don't have enough money.");
        }
        List<Lotto> lottoList = new ArrayList<>();
        int totalAmount = (int) (price / PRICE_PER_LOTTO);
        for (int count = 0; count < totalAmount; count++) {
            lottoList.add(Lotto.generate());
        }
        return Lottos.generate(lottoList);
    }
}
