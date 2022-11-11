package play.domain;

import java.util.List;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createAutoLotto() {
        return new Lotto(LottoGenerator.generateLottoNumbers());
    }

    public static Lotto MakeLotto(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
        return new Lotto(numbers);
    }

    private static void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또번호의 범위(1~45)에 맞지 않습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMatchingCount(Lotto targetLotto) {
        int count = 0;

        List<Integer> targetLottoNumber = targetLotto.getNumbers();

        for (int number : targetLottoNumber) {
            count = this.countContainNumber(number, count);
        }

        return count;
    }

    private int countContainNumber(int number, int count) {
        return this.numbers.contains(number) ? count + 1 : count;
    }

}
