package lotto.auto;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoPrinter {
    public List<LottoNumbers> print(int count) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(LottoNumbers.create());
        }
        return Collections.unmodifiableList(result);
    }
}
