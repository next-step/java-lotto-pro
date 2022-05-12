package lottoauto.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static List<Integer> numbers;

    public Lotto() {
        makeDefaultArray();
    }

    public ArrayList<Integer> getLotto() {
        Collections.shuffle(numbers);
        ArrayList<Integer> newLotto = new ArrayList<>();
        for(int i = 0 ; i < 6 ; i++) {
            newLotto.add(numbers.get(i));
        }
        return newLotto;
    }

    private void makeDefaultArray() {
        IntStream intStream = IntStream.range(1, 45);
        numbers = intStream.boxed().collect(Collectors.toList());
    }
}
