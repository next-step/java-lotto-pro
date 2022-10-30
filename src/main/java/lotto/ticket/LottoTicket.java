package lotto.ticket;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import lotto.system.MessageConstant;
import lotto.system.OutputView;

public class LottoTicket {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int SLOT_SIZE = 6;
    private ArrayList<Integer> numbers = new ArrayList<>();

    public LottoTicket(){
        numbers = new ArrayList<>(generateNumbers(new Random()));
        Collections.sort(numbers);
    }

    public LottoTicket(String winnerNumbers){
        Set<Integer> numbersSet = new HashSet<>();
        for (String s: winnerNumbers.split(",")) {
            numbersSet.add(Integer.parseInt(s));
        }
        if(numbersSet.size() != SLOT_SIZE){
            OutputView.printNotValidLottoNumbers();
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_SIX_NUMBER);
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

    public int size(){
        return numbers.size();
    }

    public void printLotto(){
        OutputView.printLotto(numbers);
    }

    public int match(LottoTicket winnerLottoTicket) {
        int count = 0;
        for (Integer number: numbers){
            count += increase(winnerLottoTicket, number);
        }
        return count;
    }

    private static int increase(LottoTicket winnerLottoTicket, Integer number) {
        return winnerLottoTicket.contains(number) ? 1 : 0;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

}