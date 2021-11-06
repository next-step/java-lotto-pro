package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoSizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static lotto.common.LottoConst.LOTTO_SIZE;
import static lotto.common.LottoConst.WINNING_NUMBER_REGEX;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(final List<Integer> numbers) {
        validation(numbers);

        this.lottoNumbers = numbers.stream()
                .distinct()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumbers fromString(final String input) {
        return new LottoNumbers(
                Arrays.stream(input.split(WINNING_NUMBER_REGEX))
                        .mapToInt(Integer::valueOf)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    public static LottoNumbers fromList(final List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    private void validation(final List<Integer> numbers) {
        lottoSizeCheck(numbers);
        duplicatedCheck(numbers);
    }

    private void duplicatedCheck(final List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (distinctNumbers.size() != numbers.size()) {
            throw new DuplicateNumberException();
        }
    }

    private void lottoSizeCheck(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoSizeException();
        }
    }

    public int matchReduce(LottoNumbers winningNumbers) {
        List<LottoNumber> winningLottoNumbers = winningNumbers.getLottoNumbers();
        int matchCounting = 0;
        for (LottoNumber winningLottoNumber : winningLottoNumbers) {
            matchCounting += matchNumber(winningLottoNumber);
        }
        return matchCounting;
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        if (this.lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private int matchNumber(LottoNumber number) {
        if (this.lottoNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        lottoNumbers.stream().forEach(lottoNumber -> joiner.add(lottoNumber.toString()));
        return joiner.toString();
    }
}
