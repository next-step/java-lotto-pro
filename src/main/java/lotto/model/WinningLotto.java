package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private List<Integer> winNumbers;

    public WinningLotto(int[] numbers) {
        winNumbers = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }

    public int size() {
        return winNumbers.size();
    }

    @Override
    public String toString() {
        return winNumbers.toString();
    }

    public int matchNumber(Lotto lotto) {
        return lotto.matchNumber(winNumbers);
    }
}
