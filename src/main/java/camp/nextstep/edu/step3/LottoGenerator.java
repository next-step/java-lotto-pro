package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final LottoNumbers numbers;

    public LottoGenerator() {
        this(new LottoNumbers());
    }

    public LottoGenerator(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto auto() {
        return numbers.extract(Collections::shuffle);
    }

    public Lotto manual(final int[] numbers) {
        return new Lotto(removeDuplicatesAndCreateBy(numbers));
    }

    private List<LottoNumber> removeDuplicatesAndCreateBy(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .distinct()
                .collect(Collectors.toList());
    }
}
