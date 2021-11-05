package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoSizeException;

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

    public List<Integer> getList() {
        return lottoNumbers.stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public int match(LottoNumbers winningNumbers) {
        List<Integer> winnings = winningNumbers.getList();
        return winnings.stream()
                .reduce(
                        0
                        , (countOfMatch, number) -> countOfMatch + matchNumber(number)
                );
    }

    private int matchNumber(int number) {
        if (this.getList().contains(number)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        lottoNumbers.stream().forEach(lottoNumber -> joiner.add(lottoNumber.toString()));
        return joiner.toString();
    }
}
