package lotto.lotto;

import java.util.List;

class RandomLottoGenerator implements LottoGenerator {

    private final List<LottoNumber> lottoNumbers;

    RandomLottoGenerator(List<LottoNumber> lottoNumbers) {
        throw new RuntimeException("create");
    }

    @Override
    public Lotto generate() {
        return null;
    }
}
