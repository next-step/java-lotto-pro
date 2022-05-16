package lotto.infrastructure.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> fullLottoNumbers;

    public LottoNumberGenerator() {
        fullLottoNumbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(fullLottoNumbers);

        List<Integer> lottoNumbers = fullLottoNumbers.subList(0, LOTTO_SIZE);

        Collections.sort(lottoNumbers);

        return new ArrayList<>(lottoNumbers);
    }
}
