package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbers {
    private final List<LottoNumber> numbers = new ArrayList<>();

    public LottoNumbers() {
        final int START_NUMBER = 1;
        final int END_NUMBER = 45;
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers.addAll(numbers);
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public Lotto extract(Consumer<List<LottoNumber>> consumer)  {
        consumer.accept(numbers);
        return new Lotto(numbers.subList(0, 6).toArray(new LottoNumber[0]));
    }
}
