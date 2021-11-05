package lotto.model;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private int[] lottoNumbers;

    public Lotto(int[] ints) {
        lottoNumbers = ints;
    }

    public int size() {
        return lottoNumbers.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers);
    }

    public int matchNumber(List<Integer> winNumbers) {
        int result = 0;
        for (int i = 0; i < lottoNumbers.length; i++) {
            result += winNumbers.contains(lottoNumbers[i]) ? 1 : 0;
        }
        return result;
    }
}
