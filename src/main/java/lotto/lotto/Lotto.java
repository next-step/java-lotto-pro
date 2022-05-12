package lotto.lotto;

import java.util.List;

public class Lotto {

    private static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        throw new RuntimeException("create");
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        throw new RuntimeException("create");
    }

    public int countMatches(Lotto other) {
        throw new RuntimeException("countMatches");
    }

    List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
