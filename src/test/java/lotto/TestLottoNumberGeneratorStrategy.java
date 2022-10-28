package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoNumberGeneratorStrategy;

public class TestLottoNumberGeneratorStrategy implements LottoNumberGeneratorStrategy {

    private final List<Integer> numbers;

    private TestLottoNumberGeneratorStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static TestLottoNumberGeneratorStrategy from(List<Integer> numbers) {
        return new TestLottoNumberGeneratorStrategy(numbers);
    }

    @Override
    public List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.from(number));
        }

        return lottoNumbers;
    }
}
