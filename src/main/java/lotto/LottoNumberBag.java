package lotto;

import lotto.view.InputView;

import java.util.List;

public class LottoNumberBag {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> lottoNumbers;

    public LottoNumberBag() {
        this.lottoNumbers = LottoNumberGenerator.generate();
        InputView.printNumbers(lottoNumbers);
    }

    public LottoNumberBag(List<Integer> numbers) {
        validNumbers(numbers);
        lottoNumbers = numbers;
    }

    public int correctCount(List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void validNumbers(List<Integer> numbers) {
        validNumberSize(numbers);
        validUnique(numbers);
        validRange(numbers);
    }

    private void validNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다");
        }
    }

    private void validUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("로또 숫자는 중복되지 않은 값이어야 합니다");
        }
    }

    private void validRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException("로또 숫자는 1 ~ 45 사이의 값이어야 합니다");
        }
    }
}
