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

    @Override
    public List<Integer> getLottoNumbers() {
        sort();
        return lottoNumbers;
    }

    private void shuffle() {
        Collections.shuffle(NUMBER_RANGE);
    }

    private void sort() {
        Collections.sort(lottoNumbers);
    }
}
