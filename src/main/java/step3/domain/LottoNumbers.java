package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(mapOf(numbers));
    }

    public String toString() {
        List<Integer> result = new ArrayList<>();

        for (LottoNumber lottoNumber : lottoNumbers) {
            result.add(lottoNumber.value());
        }

        Collections.sort(result);

        return Collections.unmodifiableList(result).toString();
    }

    public int containCount(LottoNumbers winLottoNumbers) {
        int count = 0;

        for (LottoNumber winLottoNumber : winLottoNumbers.lottoNumbers) {
            count = containCheckAndIncrementCount(count, winLottoNumber);
        }
        return count;
    }

    public boolean isContain(LottoNumber validLottoNumber) {
        return lottoNumbers.contains(validLottoNumber);
    }

    public boolean isBonusContain(LottoNumber bonusLottoNumber) {
        long matchedCount = lottoNumbers.stream()
            .filter(lottoNumber -> lottoNumber.equals(bonusLottoNumber))
            .count();

        return matchedCount != 0;
    }

    private int containCheckAndIncrementCount(int count, LottoNumber winLottoNumber) {
        if (isContain(winLottoNumber)) {
            count++;
        }
        return count;
    }

    private void validSize() {
        if (this.lottoNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new InvalidParamException(RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private static Set<LottoNumber> mapOf(List<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();

        for (int number : numbers) {
            result.add(LottoNumber.of(number));
        }

        return result;
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
