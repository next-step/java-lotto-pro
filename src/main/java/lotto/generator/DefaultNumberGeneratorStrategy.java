package lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.LottoConstant;
import lotto.domain.lotto.LottoNumber;

public class DefaultNumberGeneratorStrategy implements LottoNumberGeneratorStrategy {

    private static final List<Integer> SEED_NUMBERS =
            IntStream.rangeClosed(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER)
                    .boxed().collect(Collectors.toList());

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(SEED_NUMBERS);

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LottoConstant.LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(LottoNumber.from(SEED_NUMBERS.get(i)));
        }

        return lottoNumbers;
    }
}
