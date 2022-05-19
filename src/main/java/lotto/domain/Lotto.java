package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public Integer lottoNumber(int index) {
        return numbers.get(index);
    }

    public LottoWinner judge(List<Integer> winnerNumbers) {
        int rightCount = 0;
        for (Integer winnerNumber : winnerNumbers) {
            rightCount += returnOneIfContains(winnerNumber);
        }
        return LottoWinner.findLottoWinnerByRightCount(rightCount);
    }

    private int returnOneIfContains(Integer winnerNumber) {
        return numbers.contains(winnerNumber) ? 1 : 0;
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
