package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private int digit = 6;
    private int[] winningNumbers = new int[digit];

    public Lotto() {
        List<Integer> numbers = new ArrayList();
        for(int i=LOTTO_MIN_NUMBER; i<=LOTTO_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for(int i=0; i< winningNumbers.length; i++) {
            winningNumbers[i] = numbers.get(i);
        }
        Arrays.sort(winningNumbers);
    }

    public Lotto(int[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public boolean isMatch(int number) {
        for(int i=0; i<winningNumbers.length; i++) {
            if(winningNumbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    public int getMatchNumber(int[] numbers) {
        int matchNumber = 0;
        for(int number : numbers) {
            if(isMatch(number)) {
                matchNumber++;
            }
        }
        return matchNumber;
    }

    @Override
    public String toString() {
        String result = "[";
        for(int i=0; i<digit; i++) {
            result += winningNumbers[i]+",";
        }
        return result.substring(0,result.length()-1) + "]";
    }
}
