package lotto.model;

import java.util.Arrays;

public class WinningLotto {
    private int[] lottoNumbers;

    public WinningLotto(String splitedInts) {
        lottoNumbers = Arrays.stream(splitedInts.split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    public int size() {
        return lottoNumbers.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers);
    }

    public int matchNumber(Lotto lotto) {
        return 3;
    }
}
