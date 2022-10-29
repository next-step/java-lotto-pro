package lotto.domain.seller;

import lotto.constant.LottoConstant;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.generate.LottoNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public List<Lotto> sellAutoLotto(Money money) {
        int lottoCount = money.possibleBuyLottoCount(LottoConstant.LOTTO_PRICE);
        return Stream.generate(LottoNumberGenerator::generate)
                .limit(lottoCount)
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
