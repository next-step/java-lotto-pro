package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoNumber;

    public Lotto(List<Integer> numbers) {
        this.validateLotto(numbers);
        this.lottoNumber = numbers.stream()
                .map((number) -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumber() {
        return this.lottoNumber;
    }

    private void validateLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
