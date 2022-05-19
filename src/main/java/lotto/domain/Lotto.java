package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int SIZE = 6;
    private static final Money LOTTO_PRICE = Money.from(1000);

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumber[] lottoNumbers) {
        validateNumbersCount(lottoNumbers);
        validateDuplicated(lottoNumbers);
        this.lottoNumbers = new HashSet<>(Arrays.asList(lottoNumbers));
    }

    public Money price() {
        return LOTTO_PRICE;
    }

    public MatchResult match(Set<LottoNumber> prizeNumbers) {
        int matchCount = 0;
        for (LottoNumber prizeNumber : prizeNumbers) {
            if (lottoNumbers.contains(prizeNumber)) {
                matchCount++;
            }
        }
        return MatchResult.from(matchCount);
    }

    private void validateDuplicated(LottoNumber[] lottoNumbers) {
        if (hasDuplicatedLottoNumber(lottoNumbers)) {
            throw new IllegalArgumentException("로또는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private void validateNumbersCount(LottoNumber[] lottoNumbers) {
        if (SIZE != lottoNumbers.length) {
            throw new IllegalArgumentException(String.format("로또는 %d자리 숫자이어야 합니다.", SIZE));
        }
    }

    private boolean hasDuplicatedLottoNumber(LottoNumber[] lottoNumbers) {
        Set<LottoNumber> nonDuplicatedNumbers = new HashSet<>(Arrays.asList(lottoNumbers));
        return nonDuplicatedNumbers.size() != SIZE;
    }

    public List<LottoNumber> sortedLottoNumbers() {
        List<LottoNumber> sortedNumbers = new ArrayList<>(this.lottoNumbers);
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }

}
