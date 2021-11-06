package lotto.domain;

import lotto.domain.common.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class AutoLottoPurchase {

    private static final List<Integer> lottoNumber =
            IntStream.rangeClosed(Constant.LOTTO_MIN, Constant.LOTTO_MAX)
                    .boxed()
                    .collect(Collectors.toList());

    public List<Integer> generateLottoNumbers() {
        Collections.shuffle(lottoNumber);
        List<Integer> pickedNumber = new ArrayList<>();

        for (int i = 0; i < Constant.LOTTO_LIMIT_SIZE; i++) {
            pickedNumber.add(lottoNumber.get(i));
        }

        Collections.sort(pickedNumber);

        return pickedNumber;
    }

}
