package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public static final int LOTTO_SIZE = 6;
    public static final String DELIMITER = ",";
    public static final String DELIMITER_MESSAGE = "로또 숫자 구분자로 ,(콤마)를 입력해주세요.";
    public static final String BLANK = " ";
    public static final String NO_BLANK = "";
    private static final List<Integer> allNumbers = new ArrayList<>();

    static {
        for (int i = LottoNumber.START_NUMBER; i <= LottoNumber.END_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(allNumbers);
        return allNumbers.stream().limit(LOTTO_SIZE).collect(Collectors.toList());
    }

    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generate()));
        }
        return new Lottos(lottos);
    }

    public Lotto createWinningNumber(String winningNumberString) {
        validateDelimiter(winningNumberString);
        return new Lotto(toList(toInts(winningNumberString.replaceAll(BLANK, NO_BLANK).split(DELIMITER))));
    }

    private void validateDelimiter(String text) {
        if (!text.contains(DELIMITER)) {
            throw new IllegalArgumentException(DELIMITER_MESSAGE);
        }
    }

    private int[] toInts(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private List<Integer> toList(int[] values) {
        return Arrays.stream(values)
                .boxed()
                .collect(Collectors.toList());
    }
}
