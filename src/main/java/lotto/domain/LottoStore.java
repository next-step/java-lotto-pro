package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoStore {
    public static LottoTicket buy(GenerateStrategy GenerateStrategy) {
        Set<Integer> generatedNumber = GenerateStrategy.generate();
        return new LottoTicket(generatedNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }
}
