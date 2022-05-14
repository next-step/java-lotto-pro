package lotto.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.config.LottoGameConfig.*;

public class LottoNumberService {
    private final List<Integer> allLottoNumbers;

    public LottoNumberService() {
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
