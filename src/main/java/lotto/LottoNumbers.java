package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final int MAX_COUNT = 6;

    private ArrayList<Integer> numbers;

    public LottoNumbers() {
        this.numbers = new ArrayList<>();
        this.initWithRandomNumber();
    }
    
    public LottoNumbers(String numbersWithComma) {
        try {
            String[] winnerNumbers = numbersWithComma.split(",");
            this.setNumbersWithInput(winnerNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("Winner number is not valid.");
        }
        
    }

    public Object[] getNumbersAsArray() {
        return numbers.toArray();
    }

    private void initWithRandomNumber() {
        List<Integer> lottoNumberPool = this.generateLottoNumberPool();
        Collections.shuffle(lottoNumberPool);
        for (int i = 1; i <= MAX_COUNT; i++) {
            this.numbers.add(lottoNumberPool.get(i));
        }
        Collections.sort(this.numbers);
    }

    private List<Integer> generateLottoNumberPool() {
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberPool.add(i);
        }
        return numberPool;
    }


    private void setNumbersWithInput(String[] winnerNumbers) {
        this.validateNumbers(winnerNumbers);

        for (int i = 1; i <= MAX_COUNT; i++) {
            this.numbers.add(Integer.parseInt(winnerNumbers[i-1]));
        }
    }

    private void validateNumbers(String[] winnerNumbers) {
        if (winnerNumbers.length != MAX_COUNT) {
            throw new IllegalArgumentException(String.format("The number of winner's number should be %d", MAX_COUNT));
        }
    }

}
