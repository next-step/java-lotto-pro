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
        this.numbers = new ArrayList<>();
        try {
            String[] winnerNumbers = numbersWithComma.split(",");
            this.setNumbersWithInput(winnerNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("String input is not valid. input: %s", numbersWithComma));
        }
        Collections.sort(this.numbers);
    }

    public int[] getNumbersAsArray() {
        return this.numbers.stream().mapToInt(i -> i).toArray();
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
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

        for (String number : winnerNumbers) {
            int oneNumber = Integer.parseInt(number.trim());
            validateLottoNumber(oneNumber);
            this.numbers.add(oneNumber);
        }
    }

    private void validateLottoNumber(int oneNumber) {
        if (oneNumber < 1 || oneNumber > 45) {
            throw new IllegalArgumentException("Lotto number should be from 1 to 45.");
        }

        if (this.contains(oneNumber)) {
            throw new IllegalArgumentException("Lotto number should not be the same.");
        }
    }

    private void validateNumbers(String[] winnerNumbers) {
        if (winnerNumbers.length != MAX_COUNT) {
            throw new IllegalArgumentException(String.format("The number of winner's number should be %d", MAX_COUNT));
        }
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
