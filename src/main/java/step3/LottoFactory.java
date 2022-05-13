package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> allLottoNumbers.add(new LottoNumber(number)));
    }

    private LottoFactory() {
    }

    public static Lotto createAutoLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
                .limit(Lotto.getLottoSize())
                .collect(Collectors.toList()));
    }
}
