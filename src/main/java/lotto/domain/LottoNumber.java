package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.utils.RandomNumberUtils.*;

public class LottoNumber {

    public static final int LOTTO_SIZE = 6;

    private final List<Number> lottoNumbers = new ArrayList<>();

    public List<Number> getLottoNumber() {
        setLottoNumbers(generateAutoLottoNumbers());
        return lottoNumbers;
    }

    public List<Number> getLottoNumber(List<Integer> activeNumbers) {
        setLottoNumbers(generateActiveLottoNumbers(activeNumbers));
        return lottoNumbers;
    }

    private List<Number> generateAutoLottoNumbers() {
        Set<Number> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(getRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private List<Number> generateActiveLottoNumbers(List<Integer> activeNumbers) {
        validateActiveLottoSize(activeNumbers);
        return activeNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private Number getRandomNumber() {
        int randomNumber = generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
        return new Number(randomNumber);
    }

    private void validateActiveLottoSize(List<Integer> activeNumbers) {
        if (activeNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자 입력 필수 자리수 : " + LOTTO_SIZE);
        }
    }

    private void setLottoNumbers(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }

}
