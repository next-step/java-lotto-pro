package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import step3.common.exception.InvalidParamException;
import step3.domain.numbers.NumbersStrategy;

public class LottoNumbers {
    public static final int MAX_LOTTO_NUMBERS_SIZE = 6;
    public static final String RANGE_OUTBOUNT_SIZE_EXCEPTION_MESSAGE = String.format("로또 티켓은 %s 개의 숫자만 가능합니다.",
        MAX_LOTTO_NUMBERS_SIZE);
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
    }

    public LottoNumbers(NumbersStrategy numbersStrategy) {
        validSize(numbersStrategy);
        this.lottoNumbers = mapOf(numbersStrategy.getNumbers());
    }

    private void validSize(NumbersStrategy numbersStrategy) {
        if (numbersStrategy.getNumbers().length != MAX_LOTTO_NUMBERS_SIZE) {
            throw new InvalidParamException(RANGE_OUTBOUNT_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private List<LottoNumber> mapOf(int[] numbers) {
        List<LottoNumber> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(new LottoNumber(number));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
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
