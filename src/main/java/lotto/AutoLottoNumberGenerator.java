package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    List<Integer> NUMBERS = new ArrayList<>();

    AutoLottoNumberGenerator() {
        initialize();
    }

    private void initialize() {
        for (int number = START_NUMBER; number <= END_NUMBER; number++) {
            NUMBERS.add(number);
        }
    }

    @Override
    public List<Integer> generateSixNumbers() {
        Collections.shuffle(NUMBERS);
        List<Integer> sixNumbers = new ArrayList<>(NUMBERS.subList(0, 6));
        Collections.sort(sixNumbers);
        return sixNumbers;
    }
}
