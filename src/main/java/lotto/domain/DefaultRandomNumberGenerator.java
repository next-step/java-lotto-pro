package lotto.domain;

import java.util.Collections;
import java.util.List;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> generate() {
        final List<Integer> allNumbers = LottoNumber.allNumbers();

        Collections.shuffle(allNumbers);

        return allNumbers;
    }
}
