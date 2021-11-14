package nextstep.lotto.domain;

import nextstep.lotto.constance.LottoExceptionMessage;
import nextstep.lotto.exception.LottoRuntimeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers implements Iterable<LottoNumber> {

    public static final Integer LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        while (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            LottoNumber lottoNumber = new LottoNumber();
            lottoNumbers.add(lottoNumber);
        }

        List<LottoNumber> sorted = new ArrayList<>(lottoNumbers);
        Collections.sort(sorted);
        this.lottoNumbers = sorted;
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if (!LOTTO_NUMBER_COUNT.equals(lottoNumbers.size())) {
            throw new LottoRuntimeException(LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }

    private void validateDuplicateLottoNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> checkDuplicationCache = new LinkedHashSet<>(lottoNumbers);
        if (checkDuplicationCache.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoRuntimeException(LottoExceptionMessage.INVALID_DUPLICATE_LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }

    public Boolean isContains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Boolean isBonusBallContains(BonusBall bonusBall) {
        return bonusBall.isContain(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
