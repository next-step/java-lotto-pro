package lotto.generator;

import lotto.model.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.LottoConstant.*;

public class AutoLottoNumbersGenerator implements LottoNumbersGenerator {
    @Override
    public List<LottoNumber> drawNumbers() {
        List<LottoNumber> baseNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        Collections.shuffle(baseNumbers);

        return baseNumbers.subList(0, LOTTO_PICK_COUNT).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
