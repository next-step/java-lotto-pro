package step3.domain;

import static step3.domain.LottoNumbers.VALID_SIZE;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private LottoGenerator() {

    }

    public static Lotto createLotto(RandomGenerateStrategy randomGenerateStrategy) {
        List<LottoNumber> numberList = randomGenerateStrategy.generate()
            .subList(0, VALID_SIZE)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return new Lotto(new LottoNumbers(numberList));
    }

    public static Lotto create(String manualLottoNumbers) {
        return new Lotto(new LottoNumbers(manualLottoNumbers));
    }
}
