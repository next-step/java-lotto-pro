package lotto.domain.lotto.pick;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.RandomNumberGenerator;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> generate() {
        final List<Integer> allNumbers = LottoNumber.allNumbers();

        Collections.shuffle(allNumbers);

        return takeLottoSize(allNumbers);
    }

    private List<Integer> takeLottoSize(List<Integer> allNumbers) {
        return allNumbers.stream()
                .limit(LottoNumbers.SIZE)
                .collect(Collectors.toList());
    }
}
