package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> generate() {
        final List<Integer> allNumbers = LottoNumber.allNumbers();

        Collections.shuffle(allNumbers);

        return takeLottoSize(allNumbers);
    }

    private List<Integer> takeLottoSize(List<Integer> allNumbers) {
        return allNumbers.stream()
                .limit(Lotto.LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toList());
    }
}
