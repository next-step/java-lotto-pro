package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RandomLottoGenerator implements LottoGenerator {

    private static final List<LottoNumber> CACHED_LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                     .mapToObj(LottoNumber::of)
                     .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    RandomLottoGenerator() {
        this(CACHED_LOTTO_NUMBERS);
    }

    RandomLottoGenerator(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new FailureCreatingLottoGeneratorException();
        }
        if (lottoNumbers.size() < Lotto.SIZE) {
            throw new FailureCreatingLottoGeneratorException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Lotto generate() {
        final List<LottoNumber> copiedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(copiedLottoNumbers);
        return new Lotto(copiedLottoNumbers.subList(0, 6));
    }
}
