package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final int MAX_COUNT = 6;

    private final int NUMBER_RANGE_FROM = 1;

    private final int NUMBER_RANGE_TO = 45;

    private ArrayList<Integer> numbers;

    public LottoTicket() {
        this.numbers = new ArrayList<>();
        this.initWithRandomNumber();
    }
    
    public LottoTicket(String numbers) {
        this.numbers = new ArrayList<>();
        try {
            String[] winnerNumbers = numbers.split(",");
            this.setNumbersWithInput(winnerNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("String input is not valid. input: %s", numbers));
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
        for (int i = NUMBER_RANGE_FROM; i <= NUMBER_RANGE_TO; i++) {
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
        if (oneNumber < NUMBER_RANGE_FROM || oneNumber > NUMBER_RANGE_TO) {
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
