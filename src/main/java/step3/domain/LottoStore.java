package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.utils.LottoNumbersGenerator;

public class LottoStore {

    public static final int PRICE_PER_LOTTO = 1000;

    public Lottos purchase(long price) {
        validate(price);
        List<Lotto> lottoList = new ArrayList<>();
        int totalAmount = (int) (price / PRICE_PER_LOTTO);
        for (int count = 0; count < totalAmount; count++) {
            Numbers random = LottoNumbersGenerator.random();
            lottoList.add(Lotto.generate(random));
        }
        return Lottos.generate(lottoList);
    }

    private void validate(long price) {
        if (price < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("You don't have enough money.");
        }
    }
}
