package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

// 로또
public class Lotto {

    private List<Integer> numbers;
    private int winningNumberMatchCount;

    public Lotto(List<Integer> lottoNumbers) {
        numberCountValid(lottoNumbers);
        numberDuplicateValid(lottoNumbers);
        numberRangeValid(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public Lotto(List<Integer> numbers, int winningNumberMatchCount) {
        this(numbers);
        this.winningNumberMatchCount = winningNumberMatchCount;
    }

    public int winningNumberMatchCount(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            winningNumberMatchCheck(winningNumber);
        }
        return winningNumberMatchCount;
    }

    private void winningNumberMatchCheck(Integer winningNumber) {
        if (numbers.contains(winningNumber)) {
            winningNumberMatchCount++;
        }
    }

    private void numberCountValid(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoProperty.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void numberRangeValid(List<Integer> lottoNumbers) {
        boolean lottoNumberRangeCheck = lottoNumbers.stream()
                .allMatch(number -> number >= LottoProperty.LOTTO_START_NUMBER && number <= LottoProperty.LOTTO_END_NUMBER);

        if (!lottoNumberRangeCheck) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void numberDuplicateValid(List<Integer> lottoNumbers) {
        HashSet<Integer> nonDuplicationLottoNumber = new HashSet<>(lottoNumbers);
        if (nonDuplicationLottoNumber.size() != LottoProperty.LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
