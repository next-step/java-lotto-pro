package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutomaticNumber implements LottoNumber {
    private final List<Integer> lottoNumbers;

    public AutomaticNumber() {
        this.lottoNumbers = createAutomaticNumber();
    }

    private List<Integer> createAutomaticNumber() {
        shuffle();
        return NUMBER_RANGE.stream()
                .limit(NUMBER_SIZE)
                .collect(Collectors.toList());
    }

    private void shuffle() {
        Collections.shuffle(NUMBER_RANGE);
    }

    @Override
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
