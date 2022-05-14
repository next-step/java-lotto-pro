package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class LottoNumbers {
    private final List<LottoNumber> numbers = new ArrayList<>();

    public LottoNumbers() {
        final int minNumber = 1;
        final int maxNumber = 45;
        for (int i = minNumber; i <= maxNumber; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    public LottoNumbers(final List<LottoNumber> numbers) {
        this.numbers.addAll(numbers);
    }

    public final List<LottoNumber> extract(Consumer<List<LottoNumber>> consumer)  {
        consumer.accept(numbers);
        return Collections.unmodifiableList(numbers.subList(0, 6));
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
