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

    public final List<LottoNumber> extract(Consumer<List<LottoNumber>> consumer) {
        consumer.accept(numbers);
        return Collections.unmodifiableList(numbers.subList(0, 6));
    }

    public boolean isSize(final int size) {
        return Objects.equals(numbers.size(), size);
    }

    public boolean hasRange(final LottoNumber minNumber, final LottoNumber maxNumber) {
        return isMinNumber(minNumber) && isMaxNumber(maxNumber);
    }

    private boolean isMinNumber(final LottoNumber min) {
        return numbers.stream().anyMatch(number -> min.compareTo(number) < 0);
    }

    private boolean isMaxNumber(final LottoNumber max) {
        return numbers.stream().anyMatch(number -> max.compareTo(number) > 0);
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
