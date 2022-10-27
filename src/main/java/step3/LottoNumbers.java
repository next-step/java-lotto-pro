package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    private LottoNumbers() {
        this.numbers = new ArrayList<>();
    }

    private LottoNumbers(int startNumber, int endNumber, int selectNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int number = startNumber; number <= endNumber; number++) {
            numbers.add(number);
        }
        Collections.shuffle(numbers);
        this.numbers = numbers.subList(0, selectNumber);
        Collections.sort(this.numbers);
    }

    public static LottoNumbers generate(int startNumber, int endNumber, int selectNumber) {
        return new LottoNumbers(startNumber, endNumber, selectNumber);
    }

    public int getSize() {
        return numbers.size();
    }
}
