package camp.nextstep.edu.step3;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final LottoNumbers numbers;

    public LottoGenerator() {
        this(new LottoNumbers());
    }

    public LottoGenerator(LottoNumbers numbers) {
        System.out.println(numbers);
        this.numbers = numbers;
    }

    public Lotto auto() {
        List<LottoNumber> extract = numbers.extract(Collections::shuffle);
        return new Lotto(extract);
    }

    public Lotto manual(final List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }
}
