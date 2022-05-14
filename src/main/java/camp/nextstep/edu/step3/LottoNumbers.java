package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Lotto extract(Consumer<List<LottoNumber>> consumer)  {
        consumer.accept(numbers);
        return new Lotto(numbers.subList(0, 6));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
