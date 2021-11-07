package lotto.model;

import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> data;

    public LottoNumbers(List<LottoNumber> data) {
        validate(data);
        this.data = data;
    }

    private void validate(List<LottoNumber> data) {
        if (data == null || data.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
