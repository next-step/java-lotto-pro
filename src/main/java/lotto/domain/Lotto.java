package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final Money LOTTO_PRICE = Money.from(1000);

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumber[] lottoNumbers) {
        this.lottoNumbers = new HashSet<>(Arrays.asList(lottoNumbers));
        validateNumbersCount();
        validateDuplicated();
    }

    public Money price() {
        return LOTTO_PRICE;
    }

    public MatchResult match(List<LottoNumber> prizeNumbers) {
        int matchCount = 0;
        for (LottoNumber prizeNumber : prizeNumbers) {
            if (lottoNumbers.contains(prizeNumber)) {
                matchCount++;
            }
        }
        return MatchResult.from(matchCount);
    }

    private void validateDuplicated() {
        if (hasDuplicatedLottoNumber()) {
            throw new IllegalArgumentException("로또는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private void validateNumbersCount() {
        if (LOTTO_NUMBER_SIZE != this.lottoNumbers.size()) {
            throw new IllegalArgumentException(String.format("로또는 %d자리 숫자이어야 합니다.", LOTTO_NUMBER_SIZE));
        }
    }

    private boolean hasDuplicatedLottoNumber() {
        return this.lottoNumbers.size() != LOTTO_NUMBER_SIZE;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
