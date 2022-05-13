package study.lotto.domain;

import java.util.List;
import java.util.Objects;
import study.lotto.domain.draw.Division;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("lottoNumbers 는 null 이 될 수 없습니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Division match(LottoNumbers lottoNumbers) {
        return Division.valueOfMatchCount(this.lottoNumbers.match(lottoNumbers).size());
    }

    public List<Integer> numbers() {
        return lottoNumbers.numbers();
    }
}
