package camp.nextstep.edu.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WholeNumbers {
    private final List<WholeNumber> numbers = new ArrayList<>();

    public WholeNumbers(final WholeNumber... wholeNumbers) {
        numbers.addAll(Arrays.asList(wholeNumbers));
    }

    public int sum() {
        return numbers.stream()
                .reduce(new WholeNumber("0"), WholeNumber::add)
                .of();
    }
}
