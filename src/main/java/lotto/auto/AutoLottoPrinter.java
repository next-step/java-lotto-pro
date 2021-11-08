package lotto.auto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrinter;
import lotto.domain.Shuffleable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoPrinter implements LottoPrinter {
    private final Shuffleable shuffler;

    public AutoLottoPrinter(Shuffleable shuffler) {
        this.shuffler = shuffler;
    }

    public List<LottoNumbers> print(int count) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(LottoNumbers.create(shuffler));
        }
        return Collections.unmodifiableList(result);
    }
}
