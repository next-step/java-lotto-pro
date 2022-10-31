package step3.model;

import java.util.List;
import java.util.stream.Collectors;

public class CustomLottoGenerator implements LottoGenerator {
    private final List<Integer> customLotto;

    public CustomLottoGenerator(List<Integer> customLotto) {
        this.customLotto = customLotto;
    }

    @Override
    public Lotto generateLotto() {
        List<Number> numbers = customLotto.stream()
            .map(lottoNumber -> new Number(lottoNumber)).collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
