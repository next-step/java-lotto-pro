package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomLottoIssuanceStrategy implements LottoIssuanceStrategy {

    private static final List<Integer> LOTTO_RANDOM_NUMBERS;
    private static final int LOTTO_RANDOM_NUMBERS_START = 1;
    private static final int LOTTO_RANDOM_NUMBERS_END = 45;

    static {
        LOTTO_RANDOM_NUMBERS = IntStream.rangeClosed(LOTTO_RANDOM_NUMBERS_START, LOTTO_RANDOM_NUMBERS_END)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public boolean isIssuableLottos(LottoIssuance lottoIssuance) {
        return lottoIssuance.isRandomLottos();
    }

    @Override
    public Lottos issueLottos(LottoIssuance lottoIssuance) {
        List<Lotto> lottos = LongStream.range(0, lottoIssuance.count())
                .mapToObj(i -> createRandomLottoNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private LottoNumbers createRandomLottoNumbers() {
        Collections.shuffle(LOTTO_RANDOM_NUMBERS);
        List<LottoNumber> lottoNumbers = LOTTO_RANDOM_NUMBERS.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }
}
