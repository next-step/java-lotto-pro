package lotto.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoTicket {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int SLOT_SIZE = 6;
    ArrayList<Integer> numbers;

    public LottoTicket(){
        numbers = new ArrayList<>(generateNumbers(new Random()));
        Collections.sort(numbers);
    }

    private Set<Integer> generateNumbers(Random random) {
        Set<Integer> numbersSet = new HashSet<>();
        while (numbersSet.size() < SLOT_SIZE) {
            numbersSet.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
        }
        return numbersSet;
    }

    public ArrayList<Integer> getNumbers(){
        return numbers;
    }

}
