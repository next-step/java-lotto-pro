package study.lotto.domain;

import study.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {

    public static final int LOTTO_PRICE = 1000;

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    private static final int LOTTO_STAT_IDX = 0;
    private static final int LOTTO_END_IDX = 6;

    private static final List<Integer> rangeOfLottoNumbers = getRangeOfLottoNumbers();

    private static List<Integer> getRangeOfLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Lotto> buy(int quantity) {
        List<Lotto> allNumbers = new ArrayList<>();
        IntStream.range(NumberUtil.INIT_ZERO, quantity).forEach((i) -> {
            allNumbers.add(new Lotto(buy()));
        });
        return allNumbers;
    }

    private static List<Integer> buy() {
        Collections.shuffle(rangeOfLottoNumbers);
        return new ArrayList<>(rangeOfLottoNumbers.subList(LOTTO_STAT_IDX, LOTTO_END_IDX));
    }
}
