package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultNumberGeneratorStrategy implements LottoNumberGeneratorStrategy {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> seedNumbers;

    public DefaultNumberGeneratorStrategy() {
        this.seedNumbers = createSeedNumbers();
    }

    private List<Integer> createSeedNumbers() {
        List<Integer> seedNumbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            seedNumbers.add(i);
        }

        return seedNumbers;
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(seedNumbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(LottoNumber.from(seedNumbers.get(i)));
        }

        return lottoNumbers;
    }
}
