package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> numbers;

    private static final int SIZE = 6;

    public LottoNumbers(List<Integer> numbers) {
        List<LottoNumber> result = convertToLottoNumbers(numbers);
        validateLottoNumbers(result);
        Collections.sort(result);
        this.numbers = new ArrayList<>(result);
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int[] getNumbersAsArray() {
        int[] result = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            result[i] = this.numbers.get(i).getNumber();
        }

        return result;
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }
    private void validateLottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format("The number of lotto numbers should be %d", SIZE));
        }

        Set<Integer> lottoNumbers = new HashSet<>();
        for (LottoNumber number : numbers) {
            lottoNumbers.add(number.getNumber());
        }

        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("Duplicated number isn't allowed.");
        }
    }
}
