package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_LOTTERY_NUMBER_SIZE = 6;
    public static final String PRINT_LOTTO_NUMBERS_FORMAT = "[%s]";
    public static final String PRINT_LOTTO_NUMBERS_DELIMITER = ", ";

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validSize();
    }

    public static LottoNumbers of(LottoNumberGenerator lottoNumberGenerator) {
        return new LottoNumbers(lottoNumberGenerator.generate());
    }

    private void validSize() {
        if (this.lottoNumbers.size() != LOTTO_LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    public int containCount(LottoNumbers winningNumbers) {
        return (int) winningNumbers.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public String print() {
        List<Integer> numberList = this.lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
        String numberFormat = numberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(PRINT_LOTTO_NUMBERS_DELIMITER));
        return String.format(PRINT_LOTTO_NUMBERS_FORMAT, numberFormat) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}