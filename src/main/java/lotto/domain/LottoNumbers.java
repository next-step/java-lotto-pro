package lotto.domain;

import java.sql.Array;
import java.util.*;

public class LottoNumbers {

    private List<LottoNumber> numbers;

    private int SIZE = 6;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = new ArrayList<>(numbers);
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
