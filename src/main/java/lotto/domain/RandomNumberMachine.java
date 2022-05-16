package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RandomNumberMachine {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final Stack<LottoNumber> numbers = new Stack<>();
    private List<LottoNumber> pickedNumbers = new ArrayList<>();

    public RandomNumberMachine() {
        for (int number = MIN; number <= MAX; number++) {
            numbers.push(LottoNumber.from(number));
        }

        Collections.shuffle(numbers);
    }

    public LottoNumber popRandomNumber() {
        LottoNumber pickedNumber = numbers.pop();
        pickedNumbers.add(pickedNumber);
        return pickedNumber;
    }

    public void refill() {
        numbers.addAll(pickedNumbers);
        pickedNumbers.clear();
        Collections.shuffle(numbers);
    }

}
