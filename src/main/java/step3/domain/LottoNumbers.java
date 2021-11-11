package step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import step3.common.exception.InvalidParamException;

public class LottoNumbers {
    public static final int MAX_LOTTO_NUMBERS_SIZE = 6;
    public static final String RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE = String.format("로또 티켓은 %s 개의 숫자만 가능합니다.",
        MAX_LOTTO_NUMBERS_SIZE);

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validSize();
    }

    public static LottoNumbers of(List<LottoNumber> numbers) {
        return new LottoNumbers(new HashSet<>(numbers));
    }

    public String toCommaSerialize() {
        return lottoNumbers.stream()
            .sorted()
            .map(LottoNumber::value)
            .collect(Collectors.toList()).toString();
    }

    public int containCount(LottoNumbers winLottoNumbers) {
        int count = 0;

        for (LottoNumber winLottoNumber : winLottoNumbers.lottoNumbers) {
            count = containCheckAndIncrementCount(count, winLottoNumber);
        }
        return count;
    }

    public boolean isBonusContain(LottoNumber bonusLottoNumber) {
        return lottoNumbers.contains(bonusLottoNumber);
    }

    private void validSize() {
        if (this.lottoNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new InvalidParamException(RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private int containCheckAndIncrementCount(int count, LottoNumber winLottoNumber) {
        if (isContain(winLottoNumber)) {
            count++;
        }
        return count;
    }

    private boolean isContain(LottoNumber validLottoNumber) {
        return lottoNumbers.contains(validLottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumbers))
            return false;
        LottoNumbers that = (LottoNumbers)o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
