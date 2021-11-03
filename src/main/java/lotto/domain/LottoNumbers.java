package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoSizeException;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.LottoConst.LOTTO_SIZE;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        validation(numbers);

        this.lottoNumbers = numbers.stream()
                .distinct()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validation(List<Integer> numbers) {
        lottoSizeCheck(numbers);
        duplicatedCheck(numbers);
    }

    private void duplicatedCheck(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (distinctNumbers.size() != numbers.size()) {
            throw new DuplicateNumberException();
        }
    }

    private void lottoSizeCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoSizeException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
