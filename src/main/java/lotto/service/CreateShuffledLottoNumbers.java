package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateShuffledLottoNumbers {
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private static List<Integer> lottoNumberRangeList = createLottoNumberRangeList();

    private static List<Integer> createLottoNumberRangeList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNumberList.add(i);
        }
        return lottoNumberList;
    }

    public static List<String> createLottoNumbers() {
        Collections.shuffle(lottoNumberRangeList);
        return lottoNumberRangeList
                .stream()
                .limit(LOTTO_NUMBER_MAX_COUNT)
                .sorted()
                .map(l -> Integer.toString(l))
                .collect(Collectors.toList());
    }
}
