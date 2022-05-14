package lotto.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoLogicService {
    private final List<Integer> allLottoNumbers;
    private static final int LOTTO_GAME_NUMBER_COUNT = 6;
    private static final int LOTTO_GAME_MAXIMUM_NUMBER = 45;

    public LottoLogicService() {
        allLottoNumbers = makeAllLottoNumbers();
    }

    List<Integer> makeAllLottoNumbers() {
        return IntStream.range(1, LOTTO_GAME_MAXIMUM_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    Set<Integer> makeLottoNumbers() {
        Collections.shuffle(allLottoNumbers);
        return new HashSet<>(allLottoNumbers.subList(0, LOTTO_GAME_NUMBER_COUNT));
    }
}
