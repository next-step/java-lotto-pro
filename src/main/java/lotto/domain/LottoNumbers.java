package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;
    public static final int BONUS_NUMBER_INDEX = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private static final List<Integer> ALL_NUMBERS = initAllNumbers();
    private final List<Integer> numbers;
    private final Integer bonusNumber;
    private final RandomShuffle randomShuffle;

    public LottoNumbers() {
        this(new RandomShuffleImpl());
    }

    public LottoNumbers(RandomShuffle randomShuffle) {
        this.randomShuffle = randomShuffle;
        numbers = initNumbers();
        bonusNumber = initBonusNumber();
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

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> initNumbers() {
        randomShuffle.shuffle(ALL_NUMBERS);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            result.add(ALL_NUMBERS.get(i));
        }
        result.sort(Integer::compareTo);

        return result;
    }

    private Integer initBonusNumber() {
        return ALL_NUMBERS.get(BONUS_NUMBER_INDEX);
    }

    public WinningRank matchWinningNumbers(List<Integer> winningNumbers, Integer winningBonusNumber) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            matchCount += matchWinningNumber(winningNumber);
        }
        return WinningRank.of(matchCount, bonusNumber.equals(winningBonusNumber));
    }

    private Integer matchWinningNumber(Integer winningNumber) {
        if (numbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
