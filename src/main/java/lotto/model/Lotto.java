package lotto.model;

import java.util.Arrays;

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
}
