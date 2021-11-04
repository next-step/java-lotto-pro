package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.utils.RandomNumberUtils.*;

public class LottoNumber {

    public static final int LOTTO_SIZE = 6;

    private final List<Number> lottoNumbers = new ArrayList<>();

    public void generateLottoNumber() {
        addAllLottoNumbers(getAutoLottoNumbers());
    }

    public void generateLottoNumber(List<Integer> activeNumbers) {
        addAllLottoNumbers(getActiveLottoNumbers(activeNumbers));
    }

    private List<Number> getAutoLottoNumbers() {
        Set<Number> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(getRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private List<Number> getActiveLottoNumbers(List<Integer> activeNumbers) {
        return activeNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
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

    public List<Number> getLottoNumber() {
        return lottoNumbers;
    }

    private void addAllLottoNumbers(List<Number> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }

}
