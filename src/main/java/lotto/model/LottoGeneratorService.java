package lotto.model;

import java.util.List;
import lotto.utils.RandomNumberUtils;
import lotto.vo.Lotto;

public class LottoGeneratorService {
    private static final int LOW_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public Lotto generateLotto() {
        List<Integer> randomNumberToList = RandomNumberUtils
                .generateRandomNumberToList(LOW_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return new Lotto(randomNumberToList);
    }
}
