package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<Integer> allNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(LottoNumber.getMinLottoNumber(), LottoNumber.getMaxLottoNumber())
                .forEach(allNumbers::add);
    }

    private LottoFactory() {
    }

    public static Lotto createAutoLotto() {
        return createManualLotto(randomNumbers());
    }

    private static List<Integer> randomNumbers() {
        Collections.shuffle(allNumbers);
        return allNumbers.stream()
                .limit(Lotto.getSize())
                .collect(Collectors.toList());
    }

    public static Lotto createManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
