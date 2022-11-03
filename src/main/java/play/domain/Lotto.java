package play.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createAutoLotto() {
        return new Lotto(LottoGenerator.generateLottoNumbers());
    }

    public static Lotto MakeLotto(List<Integer> numbers) {
        return new Lotto(numbers);
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
