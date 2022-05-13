package study.lotto.automatic.domain;

import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("lottoNumbers 는 null 이 될 수 없습니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int match(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.match(lottoNumbers).size();
    }
}
