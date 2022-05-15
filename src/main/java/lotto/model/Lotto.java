package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.constant.LottoRank;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int[] convertNumbers() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public LottoRank matchRank(List<Integer> winningNumberList, BonusNumber bonusNumber) {
        return LottoRank.of(matchNumberCount(winningNumberList), bonusNumber.matchBonusNumber(numbers));
    }

    private int matchNumberCount(List<Integer> winningNumberList) {
        return Math.toIntExact(winningNumberList.stream()
                .filter(numbers::contains)
                .count());
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
