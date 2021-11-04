package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.utils.RandomNumberUtils.generateRandomNumbers;

public class LottoNumber {

    public static final int LOTTO_SIZE = 6;

    private final List<Number> lottoNumbers;

    public LottoNumber() {
        List<Number> autoLottoNumbers = getAutoLottoNumbers();
        validateLottoNumbersSize(autoLottoNumbers);
        lottoNumbers = sortAsc(autoLottoNumbers);
    }

    public LottoNumber(List<Number> activeNumbers) {
        validateLottoNumbersSize(activeNumbers);
        lottoNumbers = sortAsc(activeNumbers);
    }

    private List<Number> getAutoLottoNumbers() {
        Set<Number> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(getRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private Number getRandomNumber() {
        int randomNumber = generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
        return new Number(randomNumber);
    }

    private void validateLottoNumbersSize(List<Number> activeNumbers) {
        if (activeNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자 입력 필수 자리수 : " + LOTTO_SIZE);
        }
    }

    private List<Number> sortAsc(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Number> getLottoNumber() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
