package lotto.domain;

import lotto.exception.LottoNumberSizeException;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoMachine.LOTTO_SIZE;
import static lotto.utils.ValidationUtils.*;

public class LottoNumber {

    private final List<Number> lottoNumbers;

    public LottoNumber(List<Number> lottoNumbers) {
        validateActiveLotto(lottoNumbers);
        this.lottoNumbers = sortAsc(lottoNumbers);
    }

    public Rank getMatchRank(WinningLotto winningLotto) {
        int matchCount = 0;
        boolean matchBonus = winningLotto.isExistBonusNumber(lottoNumbers);
        for (Number number : lottoNumbers) {
            matchCount += winningLotto.isMatchNumber(number) ? 1 : 0;
        }
        return Rank.of(matchCount, matchBonus);
    }

    public boolean isContains(Number number) {
        return lottoNumbers.contains(number);
    }

    private void validateActiveLotto(List<Number> activeNumbers) {
        if (isArrayEmpty(activeNumbers)) {
            throw new LottoNumberSizeException("[ERROR] 로또의 값이 없습니다.");
        }
        if (isArrayLengthOver(activeNumbers, LOTTO_SIZE)) {
            throw new LottoNumberSizeException("[ERROR] 로또의 사이즈 보다 큽니다.");
        }
        if (isArrayLengthUnder(activeNumbers, LOTTO_SIZE)) {
            throw new LottoNumberSizeException("[ERROR] 로또의 사이즈 보다 작습니다.");
        }
    }

    private List<Number> sortAsc(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }
}
