package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.constant.LottoRank;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        List<String> lottoNumberWords = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        this.numbers = new LottoNumbers(lottoNumberWords);
    }

    public int[] convertNumbers() {
        return numbers.numberToIntArray();
    }

    public LottoRank matchRank(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return LottoRank.of(winningNumbers.matchCount(numbers), numbers.contains(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
