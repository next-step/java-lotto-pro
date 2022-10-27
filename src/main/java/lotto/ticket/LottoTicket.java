package lotto.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import lotto.system.OutputView;

public class LottoTicket {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int SLOT_SIZE = 6;
    ArrayList<Integer> numbers = new ArrayList<>();

    public LottoTicket(){
        numbers = new ArrayList<>(generateNumbers(new Random()));
        Collections.sort(numbers);
    }

    public LottoTicket(String winningNumbers){
        Set<Integer> numbersSet = new HashSet<>();
        for (String s: winningNumbers.split(",")) {
            numbersSet.add(Integer.parseInt(s));
        }
        if(numbersSet.size() != SLOT_SIZE){
            OutputView.printNotValidLottoNumbers();
            throw new IllegalArgumentException();
        }
        numbers = new ArrayList<>(numbersSet);
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Integer number : numbers){
            builder.append(number + ", ");
        }
        builder.append("]\n");
        return builder.toString();
    }

    public int match(LottoTicket winnerLottoTicket) {
        int count = 0;
        for (Integer number: numbers){
            if(winnerLottoTicket.contains(number)){
                count++;
            }
        }
        return count;
    }

    private boolean contains(Integer number) {
        return numbers.contains(number);
    }
}
