package lotto.domain;

import lotto.view.OutputView;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public static boolean isValid(List<LottoNumber> numbers) throws IllegalArgumentException {
        return isValidNumbersSize(numbers) && isValidDuplicate(numbers);
    }

    private static boolean isValidNumbersSize(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            OutputView.print("로또 번호는 6개의 숫자만 설정 가능합니다.");
            return false;
        }
        return true;
    }

    private static boolean isValidDuplicate(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            OutputView.print("로또 번호가 중복됩니다.");
            return false;
        }
        return true;
    }

    public boolean hasBonusBall(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int getCorrectCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
