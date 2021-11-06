package lotto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    public static final String LOTTO_NUMBERS_BASE_SEPARATOR = ",";
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String lottoNumbersString) {
        this(lottoNumbersString, LOTTO_NUMBERS_BASE_SEPARATOR);
    }

    public LottoNumbers(String lottoNumbersString, String separator) {
        this.lottoNumbers = new HashSet<>();
        generateLottoNumbers(lottoNumbersString, separator);
    }

    private void generateLottoNumbers(String lottoNumbersString, String separator) {
        String[] splitLottoNumbersString = lottoNumbersString.split(separator);
        for (String lottoNumberString : splitLottoNumbersString) {
            lottoNumbers.add(new LottoNumber(lottoNumberString));
        }
    }

    public boolean containsNumber(LottoNumber myLottoNumber) {
        return lottoNumbers.contains(myLottoNumber);
    }

    public int getMatchCount(LottoNumbers prizeLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(prizeLottoNumbers::containsNumber)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
