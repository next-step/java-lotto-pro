package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    private LottoNumbersFactory() {
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> allLottoNumbers = createAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        List<Integer> lottoNumbers = allLottoNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createAllLottoNumbers() {
        return IntStream.range(1, 45)
            .boxed()
            .collect(Collectors.toList());
    }
}
