package lotto.lotto;

import lotto.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RandomLottoGenerator implements LottoGenerator {

    private static final String INVALID_MESSAGE = "LottoGenerator 생성 실패했습니다. (입력값: %s, 최소 갯수: %d)";
    private static final List<LottoNumber> CACHED_LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                     .mapToObj(LottoNumber::of)
                     .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    RandomLottoGenerator() {
        this(CACHED_LOTTO_NUMBERS);
    }

    RandomLottoGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validate(lottoNumbers);
    }

    @Override
    public Lotto generate() {
        final List<LottoNumber> copiedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(copiedLottoNumbers);
        return new Lotto(copiedLottoNumbers.subList(0, 6));
    }

    private static List<LottoNumber> validate(List<LottoNumber> lottoNumbers) {
        if (CollectionUtils.isEmpty(lottoNumbers)) {
            throw new FailureCreatingLottoGeneratorException(String.format(INVALID_MESSAGE, lottoNumbers, Lotto.SIZE));
        }
        if (lottoNumbers.size() < Lotto.SIZE) {
            throw new FailureCreatingLottoGeneratorException(String.format(INVALID_MESSAGE, lottoNumbers, Lotto.SIZE));
        }
        return lottoNumbers;
    }
}
