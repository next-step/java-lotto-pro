package lotto.domain.seller;

import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.generate.LottoNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    public static List<Lotto> sellAutoLotto(int buyLottoQuantity) {
        return Stream.generate(LottoNumberGenerator::generate)
                .limit(buyLottoQuantity)
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public static List<Lotto> sellManualLotto(List<String> lottoNumbers) {
        return lottoNumbers.stream().map(v -> new Lotto(LottoNumberGenerator.generateManulLotto(v)))
                .collect(Collectors.toList());
    }

    public static int possibleBuyLottoQuantity(Money money) {
        return money.possibleBuyLottoCount(LOTTO_PRICE);
    }


}
