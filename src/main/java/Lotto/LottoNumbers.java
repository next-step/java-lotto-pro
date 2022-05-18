package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private List<Integer> numbers = new ArrayList<>();

    public LottoNumbers() {
    }

    public LottoNumbers(List<Integer> numbersList) {
        numbers = numbersList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void sort() {
        Collections.sort(numbers);
    }
}
