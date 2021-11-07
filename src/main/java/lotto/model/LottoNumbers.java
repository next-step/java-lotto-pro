package lotto.model;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> data;

    public LottoNumbers(List<LottoNumber> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
