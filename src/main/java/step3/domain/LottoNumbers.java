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
    private Set<LottoNumber> lottoNumbers;

    private LottoNumbers() {
    }

    public LottoNumbers(int[] numbers) {
        this.lottoNumbers = mapOf(numbers);
        validSize();
    }

    private Set<LottoNumber> mapOf(int[] numbers) {
        Set<LottoNumber> result = new HashSet<>();

        for (int number : numbers) {
            result.add(new LottoNumber(number));
        }

        return result;
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

    private int containCheckAndIncrementCount(int count, LottoNumber winLottoNumber) {
        if (lottoNumbers.contains(winLottoNumber)) {
            count++;
        }
        return count;
    }

    private void validSize() {
        if (this.lottoNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new InvalidParamException(RANGE_OUTBOUND_SIZE_EXCEPTION_MESSAGE);
        }
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

    public int size() {
        return lottoNumbers.size();
    }
}
