package lotto;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> values) {
        this.values = values;
    }

    public static LottoNumbers from(List<LottoNumber> values) {
        return new LottoNumbers(values);
    }
}
