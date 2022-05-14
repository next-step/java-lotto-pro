package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(LottoNumber.getMinLottoNumber(), LottoNumber.getMaxLottoNumber())
                .forEach(number -> allLottoNumbers.add(LottoNumber.of(number)));
    }

    private LottoFactory() {
    }

    public static Lotto createAutoLotto() {
        return createManualLotto(randomLottoNumbers());
    }

    private static List<LottoNumber> randomLottoNumbers() {
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers.stream()
                .limit(Lotto.getLottoSize())
                .collect(Collectors.toList());
    }

    public static Lotto createManualLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
