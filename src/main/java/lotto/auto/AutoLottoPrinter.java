package lotto.auto;

import lotto.domain.CollectionsShuffler;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoPrinter {
    private final CollectionsShuffler shuffler = new CollectionsShuffler();

    public List<LottoNumbers> print(int count) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(LottoNumbers.create(shuffler));
        }
        return Collections.unmodifiableList(result);
    }
}
