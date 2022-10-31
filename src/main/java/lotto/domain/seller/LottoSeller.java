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

    public List<Lotto> sellAutoLotto(Money money) {
        int lottoCount = money.possibleBuyLottoCount(LOTTO_PRICE);
        return Stream.generate(LottoNumberGenerator::generate)
                .limit(lottoCount)
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
