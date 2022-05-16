package study.lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(Lotto lotto) {
        this(new LottoNumbers(lotto.numbers()));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("lottoNumbers 는 null 이 될 수 없습니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int matchCount(LottoNumbers winningLottoNumbers) {
        return lottoNumbers.match(winningLottoNumbers).size();
    }

    public boolean hasNumber(LottoNumber number) {
        return lottoNumbers.has(number);
    }

    public List<Integer> numbers() {
        return lottoNumbers.numbers();
    }
}
