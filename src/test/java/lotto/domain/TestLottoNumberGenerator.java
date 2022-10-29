package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.LottoNumber;

public class TestLottoNumberGenerator {

    private final List<Integer> numbers;

    private TestLottoNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static TestLottoNumberGenerator from(List<Integer> numbers) {
        return new TestLottoNumberGenerator(numbers);
    }

    public List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.from(number));
        }

        return lottoNumbers;
    }
}
