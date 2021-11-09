package lotto.service;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateShuffledLottoNumbers {
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;
    private static List<Integer> lottoNumberRangeList = createLottoNumberRangeList();

    private static List<Integer> createLottoNumberRangeList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_START_NUMBER; i <= LottoNumber.LOTTO_END_NUMBER; i++) {
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
