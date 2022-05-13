package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumbers;

public class AutoLottoNumbersIssuer {
    private static final List<Integer> NUMBER_CANDIDATES = IntStream.range(LottoNumbers.MINIMUM_NUMBER,
                    LottoNumbers.MAXIMUM_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    public static LottoNumbers issueLottoNumbers() {
        Collections.shuffle(NUMBER_CANDIDATES);
        final List<Integer> numbers = new ArrayList<>(NUMBER_CANDIDATES.subList(0, LottoNumbers.AMOUNT_OF_NUMBERS));
        Collections.sort(numbers);
        return new LottoNumbers(numbers);
    }
}
