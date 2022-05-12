package camp.nextstep.edu.step2;

import java.util.Arrays;
import java.util.List;

public class WholeNumbers {
    private final List<WholeNumber> numbers;

    public WholeNumbers(final String ... numbers) {
       this(Arrays.stream(numbers).map(WholeNumber::new).toArray(WholeNumber[]::new));
    }

    public WholeNumbers(final WholeNumber... wholeNumbers) {
        numbers = Arrays.asList(wholeNumbers);
    }

    public int sum() {
        return numbers.stream()
                .reduce(new WholeNumber("0"), WholeNumber::add)
                .of();
    }
}
