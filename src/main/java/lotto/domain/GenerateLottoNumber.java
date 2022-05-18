package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GenerateLottoNumber {
    protected static final List<Integer> ALL_NUMBERS = initAllNumbers();
    private final RandomShuffle randomShuffle;

    public GenerateLottoNumber() {
        this(new RandomShuffleImpl());
    }

    public GenerateLottoNumber(RandomShuffle randomShuffle) {
        this.randomShuffle = randomShuffle;
    }

    private static List<Integer> initAllNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = LottoNumbers.MIN_NUMBER; i <= LottoNumbers.MAX_NUMBER; i++) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> initNumbers() {
        randomShuffle.shuffle(ALL_NUMBERS);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.LOTTO_SIZE; i++) {
            result.add(ALL_NUMBERS.get(i));
        }

        return result;
    }
}
