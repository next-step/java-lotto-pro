package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.config.LottoGameConfig.*;

public class LottoNumberGenerator {
    private final List<Integer> allLottoNumbers;

    public LottoNumberGenerator() {
        allLottoNumbers = makeAllLottoNumbers();
    }

    List<Integer> makeAllLottoNumbers() {
        return IntStream.range(1, LOTTO_GAME_MAXIMUM_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> makeLottoNumbers() {
        Collections.shuffle(allLottoNumbers);
        return new ArrayList<>(allLottoNumbers.subList(0, LOTTO_GAME_NUMBER_COUNT));
    }
}
