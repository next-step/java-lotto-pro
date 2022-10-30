package step3.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {
    private LottoFactory() {

    }

    public static Lotto create(NumberGenerateStrategy numberGenerateStrategy) {
        Set<Integer> generatedNumber = numberGenerateStrategy.generate();
        LottoNumbers lottoNumbers = new LottoNumbers(generatedNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        return new Lotto(lottoNumbers);
    }
}
