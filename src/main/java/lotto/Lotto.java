package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    public static final int LOTTO_MAX_SIZE = 6;
    List<Integer> lotto;

    public Lotto() {
        this.lotto = createLotto();
    }

    private List<Integer> createLotto() {
        List<Integer> allNumbers = IntStream.range(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(allNumbers);
        List<Integer> lottoNumbers = allNumbers.stream().limit(LOTTO_MAX_SIZE).collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }
}
