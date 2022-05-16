package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int DEFAULT_NUMBER_SIZE = 6;
    private final Money price;
    private final List<LottoNumber> lottoNumbers;
    private final int lottoNumberSize;

    public Lotto(Money price, LottoNumber[] lottoNumbers) {
        this.price = price;
        this.lottoNumberSize = DEFAULT_NUMBER_SIZE;
        this.lottoNumbers = Arrays.asList(lottoNumbers);
        validateNumbersCount();
        validateDuplicated();
    }

    public Money price() {
        return this.price;
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
        if (lottoNumberSize != this.lottoNumbers.size()) {
            throw new IllegalArgumentException(String.format("로또는 %d자리 숫자이어야 합니다.", lottoNumberSize));
        }
    }

    private boolean hasDuplicatedLottoNumber() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(this.lottoNumbers);
        return this.lottoNumbers.size() != lottoNumberSet.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
