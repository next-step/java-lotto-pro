package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private static final List<Integer> ALL_NUMBERS = initAllNumbers();
    private final List<Integer> numbers;
    private final RandomShuffle randomShuffle;

    public LottoNumbers() {
        this(new RandomShuffleImpl());
    }

    public LottoNumbers(RandomShuffle randomShuffle) {
        this.randomShuffle = randomShuffle;
        numbers = initNumbers();
    }

    private static List<Integer> initAllNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> initNumbers() {
        randomShuffle.shuffle(ALL_NUMBERS);
        List<Integer> result = ALL_NUMBERS.subList(0, LOTTO_SIZE);
        result.sort(Integer::compareTo);

        return result;
    }

    public WinningRank matchWinningNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            matchCount += matchWinningNumber(winningNumber);
        }
        return WinningRank.getWinningRank(matchCount);
    }

    private Integer matchWinningNumber(Integer winningNumber) {
        if (numbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
