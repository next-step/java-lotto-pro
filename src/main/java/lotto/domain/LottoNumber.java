package lotto.domain;

import java.util.*;

import static lotto.utils.RandomNumberUtils.*;

public class LottoNumber {

    public static final int LOTTO_SIZE = 6;

    private List<Number> lottoNumbers;

    public LottoNumber() {
        this.lottoNumbers = generateNumbers();
    }

    private List<Number> generateNumbers() {
        Set<Number> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(new Number(generateRandomNumbers(MIN_NUMBER, MAX_NUMBER)));
        }

        return sortAsc(new ArrayList<>(numbers));
    }

    private ArrayList<Number> sortAsc(ArrayList<Number> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }
}
