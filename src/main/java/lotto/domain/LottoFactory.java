package lotto.domain;

import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class LottoFactory {
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static List<LottoNumber> lottoNumberList;

    public static Lotto autoGenerator() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(
                LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBERS_COUNT)
                .collect(Collectors.toList())
        );
    }

    public static Lotto manualGenerator(String input) {
        String[] inputArr = input.replace(" ", "").split(",");
        vaildCount(inputArr);
        List<LottoNumber> list = new ArrayList<>();
        for (String s : inputArr) {
            list.add(new LottoNumber(s));
        }
        return new Lotto(list);
    }

    private static void vaildCount(String[] input) {
        Set<String> set = new HashSet<>();
        for (String s : input) {
            set.add(s);
        }
        if (set.size() != 6) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
